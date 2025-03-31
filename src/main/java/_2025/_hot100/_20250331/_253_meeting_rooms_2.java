package _2025._hot100._20250331;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 会议室Ⅱ
 *
 * @author 佳叙
 * @date 2025/3/31
 * @description <a href="https://leetcode.cn/problems/meeting-rooms-ii/description/"/>
 */
public class _253_meeting_rooms_2 {

    /**
     * 上下车问题
     *
     *
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        return minMeetingRoomsWithHeap(intervals);
    }

    /**
     * 扫描线，记录所有时间节点
     *
     * @param intervals
     * @return
     */
    private int minMeetingRoomsWithTimeline(int[][] intervals) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int in  = intervals[i][0];
            int out = intervals[i][1];

            map.put(in,  Optional.ofNullable(map.get(in)).orElse(0) + 1);
            map.put(out, Optional.ofNullable(map.get(out)).orElse(0) - 1);
        }

        int num = 0;
        int max = 0;
        for (Integer time : map.keySet().stream().sorted().collect(Collectors.toList())) {
            num += map.get(time);
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    /**
     * 堆，设定以结束时间为准的最小堆，判断新元素进来时，是否可以直接占用已有会议室
     *
     * @param intervals
     * @return
     */
    private int minMeetingRoomsWithHeap(int[][] intervals) {
        // Sort with start time increasing.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!queue.isEmpty() && queue.peek()[1] <= intervals[i][0]) {
                queue.poll();
            }
            queue.offer(intervals[i]);

            if (queue.size() > max) {
                max = queue.size();
            }
        }

        return max;
    }



}