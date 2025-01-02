package remove_duplicates_from_sorted_array;

import java.util.Arrays;

class Solution {

    public static int removeDuplicates(int[] nums) {
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            nums[last] = current;
            while (i < nums.length - 1 && current == nums[i + 1]) {
                i++;
            }
            last++;
        }
        return last;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,1,2};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));


        int[] b = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(b));
        System.out.println(Arrays.toString(b));

        int[] c = new int[] {0,0,1,1,1,2,2,3,3,4,4};
        System.out.println(removeDuplicates(c));
        System.out.println(Arrays.toString(c));

        int[] d = new int[] {0,0};
        System.out.println(removeDuplicates(d));
        System.out.println(Arrays.toString(d));

        int[] e = new int[] {};
        System.out.println(removeDuplicates(e));
        System.out.println(Arrays.toString(e));

        int[] f = new int[] {1};
        System.out.println(removeDuplicates(f));
        System.out.println(Arrays.toString(f));

        int[] g = new int[] {1, 2};
        System.out.println(removeDuplicates(g));
        System.out.println(Arrays.toString(g));
    }
}
