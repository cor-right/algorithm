package _2025.random;

import java.util.*;

/**
 * 找出 3 位偶数
 *
 * @author 佳叙
 * @date 2025/4/4
 * @description <a href="https://leetcode.cn/problems/finding-3-digit-even-numbers/description/"/>
 */
public class _2094_finding_3_digit_event_numbers {

    /**
     *
     * @param digits
     * @return
     */
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> ans = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < digits.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (digits[k] % 2 == 1) {
                        continue;
                    }

                    ans.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }

        int[] ansArr = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            ansArr[i++] = num;
        }

        return ansArr;
    }

    public int[] findEvenNumbers2(int[] digits) {
        int[] digitCnt = new int[10];
        for (int num : digits) {
            digitCnt[num]++;
        }

        List<Integer> ans = new LinkedList<>();

        Map<Integer, Integer> times = new HashMap<>();
        for (int i = 100; i < 999; i += 2) {

            int digit = i;
            for (int j = 0; j < 3; j++) {
                times.put(digit % 10, times.getOrDefault(digit % 10, 0) + 1);
                digit /= 10;
            }

            if (times.entrySet().stream().allMatch(e -> digitCnt[e.getKey()] >= e.getValue())) {
                ans.add(i);
            }

            times.clear();
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }



    }