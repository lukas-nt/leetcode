package next_permutation;

import java.util.Arrays;

class Solution {

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        boolean swapped = false;
        int minIndex = nums.length - 1;
        int min = nums[minIndex];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                int tmp2;
                for (int j = i + 1; j < nums.length; j++) {
                    tmp2 = nums[j];
                    nums[j] = tmp;
                    tmp = tmp2;
                }
                swapped = true;
                break;
            }
        }
        if (!swapped) {
            for (int i = 0; i < nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = tmp;
            }
        }
    }

    public static void calculateAndPrint(int[] nums) {
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        calculateAndPrint(new int[] {1,2,3});
        calculateAndPrint(new int[] {3,2,1});
        calculateAndPrint(new int[] {1,1,5});
        calculateAndPrint(new int[] {1});
        calculateAndPrint(new int[] {});
        calculateAndPrint(new int[] {1,2,3,4,5});
        calculateAndPrint(new int[] {1,2,3,4,5,5,5});
        calculateAndPrint(new int[] {1,1,1,1});
        calculateAndPrint(new int[] {5,4,3,2,1});
        calculateAndPrint(new int[] {1,3,2});
        calculateAndPrint(new int[] {2,3,1});
    }
}
