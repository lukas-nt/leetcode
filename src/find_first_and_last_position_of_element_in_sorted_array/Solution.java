package find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

class Solution {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1,-1};
        if (nums[0] == target && nums[nums.length - 1] == target) return new int[] {0,nums.length-1};
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (high - low > 1) {
            int num = nums[mid];
            if (num < target) {
                low = mid;
            } else if (num > target) {
                high = mid;
            } else if (mid - 1 < 0 || nums[mid - 1] != target) {
                break;
            } else {
                high = mid;
            }

            if (high - low == 1) {
                if (nums[low] == target) {
                    mid = low;
                } else if (nums[high] == target) {
                    mid = high;
                } else {
                    mid = -1;
                }
                break;
            }

            mid = low + (high - low) / 2;
        }

        int lowResult = -1;
        if (mid != -1 && nums[mid] == target) lowResult = mid;

        low = 0;
        high = nums.length - 1;
        mid = low + (high - low) / 2;
        while (high - low > 1) {
            int num = nums[mid];
            if (num < target) {
                low = mid;
            } else if (num > target) {
                high = mid;
            } else if (mid + 1 >= nums.length || nums[mid + 1] != target) {
                break;
            } else {
                low = mid;
            }

            if (high - low == 1) {
                if (nums[high] == target) {
                    mid = high;
                } else if (nums[low] == target) {
                    mid = low;
                } else {
                    mid = -1;
                }
                break;
            }

            mid = low + (high - low) / 2;
        }

        int highResult = -1;
        if (mid != -1 && nums[mid] == target) highResult = mid;

        return new int[] {lowResult, highResult};
    }

    public static void printResult(int[] nums, int target) {
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static void main(String[] args) {
        printResult(new int[] {5,7,7,8,8,10}, 8);
        printResult(new int[] {5,7,7,8,8,10}, 6);
        printResult(new int[] {}, 0);
        printResult(new int[] {5,7,7,8,8,8,8,8,8,10}, 8);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,10}, 7);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,10}, 1);
        printResult(new int[] {5,7,7,7,7,7,7,8,8,8,8,8,8,9,10}, 9);
        printResult(new int[] {0}, 0);
        printResult(new int[] {0,0}, 0);
        printResult(new int[] {0,0,0}, 0);
        printResult(new int[] {0,0,0,1}, 1);
        printResult(new int[] {0,0,0,1,1}, 1);
    }
}