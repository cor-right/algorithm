package hot100;

import java.util.ArrayList;
import java.util.List;

public class Hot15_doublePointer {

    public static List<List<Integer>> threeSum(int[] nums) {

        quickSort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            while (i > 0 && i < nums.length && nums[i] == nums[i - 1] ) {
                i++;
            }

            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[head] + nums[tail] + nums[i];

                if (sum > 0) {
                    tail--;
                }
                else if (sum < 0) {
                    head++;
                }
                else {
                    List<Integer> singleRes = new ArrayList<>(3);
                    singleRes.add(nums[head]);
                    singleRes.add(nums[i]);
                    singleRes.add(nums[tail]);
                    results.add(singleRes);

                    while (head < tail && nums[head + 1] == nums[head]) {
                        head++;
                    }
                    while (head < tail && nums[tail - 1] == nums[tail]) {
                        tail--;
                    }
                    head++;
                    tail--;
                }
            }
        }

        return new ArrayList<>(results);

    }


    private static void quickSort(int[] nums) {
        sortCore(nums, 0, nums.length - 1);
    }

    private static void sortCore(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int base = nums[start];

        int head = start;
        int tail = end;
        while (head < tail) {
            while (nums[tail] >= base && tail > head) {
                tail--;
            }
            nums[head] = nums[tail];
            while (nums[head] <= base && head < tail) {
                head++;
            }
            nums[tail] = nums[head];
        }
        nums[head] = base;

        sortCore(nums, start, head - 1);
        sortCore(nums, head + 1, end);
    }

    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(ints));
    }

}
