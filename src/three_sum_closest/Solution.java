package three_sum_closest;

import java.util.List;
import java.util.TreeMap;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        var doubles = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var secondKey = nums[i] + nums[j];
                var hash = i * nums.length + j;
                doubles.put(secondKey, hash);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
