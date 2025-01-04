package remove_element;

import java.util.Arrays;

public class Solution {

    public static int removeElement(int[] nums, int val) {
        int move = 0;
        for (int i = 0; i < nums.length; i++) {
            int check = nums[i];
            if (check == val) {
                move++;
            } else {
                nums[i - move] = check;
            }
        }
        return nums.length - move;
    }

    public static void printResult(int[] nums, int val) {
        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        printResult(new int[] {3,2,2,3}, 3);
        printResult(new int[] {0,1,2,2,3,0,4,2}, 2);
    }
}
