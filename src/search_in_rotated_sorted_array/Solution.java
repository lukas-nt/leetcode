package search_in_rotated_sorted_array;

import java.util.Arrays;

class Solution {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 2) {
            return (nums[0] == target) ? 0 : (nums[1] == target ? 1 : -1);
        }
        //System.out.printf("nums: %s, target: %s\n", Arrays.toString(nums), target);
        int kLow = 0;
        int kHigh = nums.length - 1;
        int k = kLow + (kHigh - kLow) / 2;
        while (kHigh - kLow > 1) {
            if (nums[k] > nums[nums.length - 1]) {
                kLow = k;
            } else {
                kHigh = k;
            }
            //System.out.printf("kLow: %d, kHigh: %d, k: %d\n", kLow, kHigh, k);
            k = kLow + (kHigh - kLow) / 2;
        }
        if (nums.length > 1 && nums[0] < nums[nums.length - 1]) k = 0;
        else k++;

        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (high - low > 1) {
            if (nums[(mid + k) % nums.length] >= target) {
                high = mid;
            } else {
               low = mid;
            }
            //System.out.printf("low: %d, high: %d, mid: %d\n", low, high, mid);
            mid = low + (high - low) / 2;

            if (nums[(low + k) % nums.length] == target) {
                mid = low;
                break;
            } else if (nums[(high + k) % nums.length] == target) {
                mid = high;
                break;
            }
        }
        int result = nums[(mid + k) % nums.length] == target ? (mid + k) % nums.length : -1;
        //System.out.printf("result: %d\n", result);
        return result;
    }

    public static void main(String[] args) {
        search(new int[] {4,5,6,7,0,1,2}, 0);
        search(new int[] {0,1,2,4,5,6,7}, 0);
        search(new int[] {7,0,1,2,4,5,6}, 0);
        search(new int[] {6,7,0,1,2,4,5}, 0);
        search(new int[] {1,2,3}, 0);
        search(new int[] {3,4,0,1,2,3}, 0);
        search(new int[] {1,2}, 0);
        search(new int[] {1}, 0);
        search(new int[] {}, 0);
        search(new int[] {1,2,3,3,3,4,4,0}, 0);
        search(new int[] {1,3}, 3);
        search(new int[] {1,3}, 1);
        search(new int[] {4,5,6,7,0,1,2}, 3);
        search(new int[] {1,3,5}, 5);
        search(new int[] {1,3,5}, 3);
        search(new int[] {3}, 3);
        search(new int[] {3,5}, 3);

    }
}