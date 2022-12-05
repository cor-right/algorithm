package offer.day16;

import java.util.HashSet;
import java.util.Set;

/**
 * @code https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=108mt86
 *
 * 面试题61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 */
public class Offer61 {

    /**
        最终需要满足条件，排除王，
        最大值max，最小值除0外是min，王数n，则max - min <= 5
        不能有相同的牌，除了王
     */
    public boolean isStraight(int[] nums) {
        int kingNum = 0;
        int max = -1;
        int min = 14;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                kingNum++;
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            set.add(nums[i]);
        }

        if (set.size() != (5 - kingNum) || max - min >= 5) {
            return false;
        }
        return true;

    }

}
