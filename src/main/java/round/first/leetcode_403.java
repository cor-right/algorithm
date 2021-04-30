package round.first;

import java.util.*;

/**
 * 403. 青蛙过河
 *
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 *
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_403 {

    public boolean canCross(int[] stones) {
        return canCrossMemorySearch(stones);
    }

    /**
     * 记忆化搜索
     *
     * DFS + 查找/数组INDEX
     *
     * stone.length 范围是 1 ~ 2000，空间不大
     *
     * @param stones
     * @return
     */
    public static boolean canCrossMemorySearch(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }

        Map<Integer, Map<Integer, Boolean>> visitMap = new HashMap<>();

        return dfs(stones, 0, visitMap, 0);
    }

    public static  boolean dfs(int[] stones, int stoneIndex, Map<Integer, Map<Integer, Boolean>> visitMap, int jumpDis) {
        System.out.println("stoneIndex: " + stoneIndex + ", jumpDis: " + jumpDis);
        if (visited(visitMap, stoneIndex, jumpDis)) {
            return false;
        }

        if (stoneIndex == stones.length - 1) {
            return true;
        }

        Map<Integer, Boolean> map = visitMap.get(stoneIndex);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(jumpDis, true);
        visitMap.put(stoneIndex, map);

        boolean resultFlag;
        for (int i = - 1; i <= 1; i++) {
            int targetjumpDis = jumpDis + i;
            if (targetjumpDis == 0) {
                continue;
            }

            int targetIndex = search(stones, targetjumpDis + stones[stoneIndex]);
            if (targetIndex == -1) {
                continue;
            }

            resultFlag = dfs(stones, targetIndex, visitMap, stones[targetIndex] - stones[stoneIndex]);
            if (resultFlag) {
                return true;
            }
        }

        return false;
    }

    private static int search(int[] stones, int pos) {
        int left = 0;
        int right = stones.length;
        while (left < right) {
            int mid = (left + right) / 2;

            System.out.println("left: " + left + ", mid: " + mid + ", right: " + right + ", pos: " + pos);
            if (pos > stones[mid]) {
                left = mid + 1;
            } else if (pos < stones[mid]) {
                right = mid;
            } else {
                return mid;
            }

        }
        return -1;
    }

    private static boolean visited(Map<Integer, Map<Integer, Boolean>> visitMap, int index, int jumpDis) {
        Map<Integer, Boolean> map = visitMap.get(index);
        if (map == null) {
            return false;
        }

        Boolean visit = map.get(jumpDis);
        if (visit == null) {
            return false;
        }
        return visit;
    }
}
