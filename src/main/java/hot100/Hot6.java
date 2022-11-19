package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *  
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot6 {

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int rowNum = 0;
        List<StringBuilder> rowStrings = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rowStrings.add(new StringBuilder());
        }

        boolean flag = true; // true : increase

        for (int i = 0; i < s.length(); i++) {
            rowStrings.get(rowNum).append(s.charAt(i));

            if ((flag && rowNum + 1 >= numRows) || (!flag && rowNum - 1 < 0)) {
                flag = !flag;
            }

            rowNum = flag ? rowNum + 1: rowNum - 1;
        }

        return rowStrings.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

}
