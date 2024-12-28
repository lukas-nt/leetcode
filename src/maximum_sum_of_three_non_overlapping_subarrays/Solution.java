package maximum_sum_of_three_non_overlapping_subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    record KSum(int sum, int i) {}

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        var sortedSums = new ArrayList<KSum>();
        int ksum = 0;
        for (int i = 0; i < k; i++) {
            ksum += nums[i];
        }
        sortedSums.add(new KSum(ksum, 0));
        for (int i = k; i < nums.length; i++) {
            ksum -= nums[i - k];
            ksum += nums[i];
            sortedSums.add(new KSum(ksum, i - k + 1));
        }
        sortedSums.sort(Comparator.comparingInt(a -> -a.sum));

        int[] result = new int[3];
        result[0] = sortedSums.get(0).i;
        result[1] = -k;
        result[2] = -k;
        int r = 1;
        for (int i = 1; i < sortedSums.size(); i++) {
            var current = sortedSums.get(i);
            boolean add = true;
            for (int j : result) {
                if (!(current.i <= j - k || current.i >= j + k)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                result[r] = current.i;
                r++;
            }
            if (r > 2) break;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        maxSumOfThreeSubarrays(new int[] {1,2,1,2,6,7,5,1}, 2);
        maxSumOfThreeSubarrays(new int[] {1,2,1,2,1,2,1,2,1}, 2);
    }
}