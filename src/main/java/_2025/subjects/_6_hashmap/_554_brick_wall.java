package _2025.subjects._6_hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 砖墙
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/brick-wall/"/>
 */
public class _554_brick_wall {

    /**
     * 前缀和 + 哈希表，哈希表记录前缀和出现的次数，key 是前缀，也就是边缘坐标，value 是出现次数
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> prefixMap = new HashMap<>();

        int max = 0;
        for (List<Integer> row : wall) {
            int prefix = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                prefix += row.get(i);

                int edgeNum = prefixMap.getOrDefault(prefix, 0) + 1;
                prefixMap.put(prefix, edgeNum);
                max = Math.max(max, edgeNum);
            }
        }

        return wall.size() - max;
    }

}