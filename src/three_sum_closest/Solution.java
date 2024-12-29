package three_sum_closest;

import java.util.TreeMap;

class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        var doubles = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var secondKey = nums[i] + nums[j];
                var hash = i * nums.length + j;
                doubles.put(secondKey, hash);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int best = target - first;
            var lowEntry = doubles.floorEntry(best);
            if (lowEntry != null) {
                int lowAttempt = first + lowEntry.getKey();
                int lowDiff = Math.abs(lowAttempt - target);
                boolean lowIllegal = lowEntry.getValue() / nums.length == i || lowEntry.getValue() % nums.length == i;
                if (lowDiff < Math.abs(target - closest) && !lowIllegal) {
                    closest = lowAttempt;
                }
            }

            var highEntry = doubles.ceilingEntry(best);
            if (highEntry != null) {
                int highAttempt = first + highEntry.getKey();
                int highDiff = Math.abs(highAttempt - target);
                boolean highIllegal = highEntry.getValue() / nums.length == i || highEntry.getValue() % nums.length == i;

                if (highDiff < Math.abs(target - closest) && !highIllegal) {
                    closest = highAttempt;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[] {-1,2,1,-4}, 1);
        threeSumClosest(new int[] {0,0,0}, 1);
        threeSumClosest(new int[] {-1,3,1,-4}, 1);
        threeSumClosest(new int[] {-1,3,1,-4}, 3);
        threeSumClosest(new int[] {-1,3,1,-4}, -3);

    }
}
