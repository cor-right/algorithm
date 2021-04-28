package round.first;

/**
 * 633. 平方数之和
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * time: 2021-04-28
 */
public class leetcode_633 {


    public boolean judgeSquareSum(int c) {
//        return matrixSearch(c);
        return normalSearch(c);
    }

    /**
     * 双指针，矩阵搜索
     *
     * this is better
     *
     * @param c
     * @return
     */
    public boolean matrixSearch(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);

        while (low <= high) {
            int sum = low * low + high * high;

            if (sum == c) {
                return true;
            }
            else if (sum < c) {
                low++;
            }
            else {
                high --;
            }
        }
        return false;
    }

    /**
     * 单一指针，列表搜素
     *
     * @param c
     * @return
     */
    public boolean normalSearch(int c) {
        for (int a = 0; a * a <= c / 2; a++) {
            int b = c - a * a;

            double sqrtB = Math.sqrt(b);
            if ((int)sqrtB == sqrtB) {
                return true;
            }
        }
        return false;
    }



}
