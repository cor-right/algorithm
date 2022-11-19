package hot100;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1 动态规划要素
 * 动态规划有三要素：阶段、状态和决策。
 *
 * 阶段：
 *
 * 把一个问题的过程，恰当地分为若干个相互联系的阶段，以便于按一定的次序去求解。描述阶段的变量称为阶段变量。阶段的划分，一般是根据时间和空间的自然特征来进行的，但要便于问题转化为多阶段决策。
 *
 * 状态：
 *
 * 表示每个阶段开始所处的自然状况或客观条件。通常一个阶段有若干个状态（也可能只有一个状态），描述过程状态的变量称为状态变量。
 *
 * 决策：
 *
 * 表示当过程处于某一阶段的某个状态时，可以作出不同的决定，从而确定下一阶段的状态，这种决定称为决策。
 *
 * 一般流程：
 *
 * 划分阶段 -> 正确选择状态变量 -> 确定状态转移方程
 *
 * -> 确定阶段指标函数和最优指标函数，建立动态规划基本方程。
 *
 * 2 动态规划的适用范围
 * 动态规划用于解决多阶段决策最优化问题，但也不是所有最优化问题都可以用动态规划来解答。用动态规划的最优化问题要满足两个条件：
 *
 * a) 最优子结构(最优化原理)
 *
 * 作为整个过程的最优策略具有这样的性质：无论过去的状态和决策如何，相对于前面的决策所形成的状态而言，余下的决策序列必然构成最优子策略。”也就是说，一个最优策略的子策略也是最优的。
 *
 * b) 无后效性
 *
 * 如果某阶段状态给定后，则在这个阶段以后过程的发展不受这个阶段以前各段状态的影响。就是说在状态i求解时用到状态j，状态j求解用到状态k...,状态N。而状态N要用到状态i，这样的求解过程形成了环就没法用动态规划解答。也就是说当前状态是前面状态的完美总结，现在与过去无关。有的问题换一个划分状态或阶段的方法就满足无后效性，这样的问题仍然可以用动态规划解。
 *
 * 如果状态变量不能满足无后效性的要求，应适当地改变状态的定义或规定方法。
 *
 * 3 动态规划解决问题的一般思路
 * 拿到多阶段决策最优化问题后，第一步要判断这个问题是否可以用动态规划解决，如果不能就要考虑搜索或者贪心了。当确定问题可以用动态规划后，可以用下面介绍的方法解决问题：
 *
 * a) 模型匹配法
 *
 * 这个是最先考虑的。主要是看看问题是不是自己熟悉的某个基本的模型，如背包模型等，是的话就直接套用了，当然要注意其中的变动。有很多考题是基本模型的变型，小心条件。这些基本的模型将在下面的分类中以算法题的形式一一介绍。
 *
 * b) 三要素法
 *
 * 仔细分析问题尝试着确定动态规划的三要素，不同的问题的确定方形不同：
 *
 * 先确定阶段的问题：数塔问题和走路问题。
 *
 * 先确定状态的问题：大多数都是先确定状态。
 *
 * 先确定决策问题：背包问题。
 *
 * 一般都是先从比较明显的地方入手，至于怎么知道哪个明显就看经验，多做题就会发现。
 *
 * c) 寻找规律法
 *
 * 耐心分析几组数据，找找有没有什么规律。
 *
 * d) 边界条件法
 *
 * 找到问题的边界条件，然后考虑边界条件与它邻接状态之间的关系。
 *
 * 接下来几篇通过具体例题来说明。
 *
 */
public class Hot5 {

        /**
         * 最长回文字符串
         *
         *
         * 从每一个点上向两端扩散，如果 P(i, j) 是回文，则 P(i+1, j-1) 是否回文
         *
         *
         * @param s
         * @return
         */
        public static String longestPalindrome(String s) {

            if (s == null || s.length() == 0) {
                return "";
            }
            if (s.length() == 1) {
                return s;
            }
            if (s.length() == 2 ) {
                return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
            }

            // boolean [leftBound] [rightBound]
            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }

            int finalLeft = 0;
            int finalRight = 0;
            int maxLen = -1;

            // l 是子串长度
            // i 是当前左边界
            for (int l = 2; l <= s.length(); l++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + l - 1;

                    if (j > s.length() - 1) {
                        break;
                    }
                    if (i > j) {
                        break;
                    }

                    System.out.println("l " + l + " i " + i + " j " + j);


                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 2) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }

                        if (dp[i][j] && j - i > maxLen) {
                            maxLen = i - j;
                            finalLeft = i;
                            finalRight = j;
                        }
                    }
                }

            }

            return s.substring(finalLeft, finalRight + 1);
        }

        public static void main(String[] args) {
            System.out.println(longestPalindrome("abcda"));
        }


}
