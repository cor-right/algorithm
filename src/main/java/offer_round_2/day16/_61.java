package offer_round_2.day16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
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
 * 输入: [0,0,1,2,5] 5 4 2 34567
 * 输出: True
 *
 * x
 *
 * 3 2
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *
 * 通过次数209,526提交次数460,739
 */
public class _61 {

    //
    public boolean isStraight(int[] nums) {
        int max = -1;
        int min = 14;

        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            if (numList.contains(num)) {
                return false;
            }
            else if (num != 0){
                numList.add(num);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }

        return max - min < 5;
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false，常量池
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); // false，equals不处理类型
    }
}
