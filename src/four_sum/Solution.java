package four_sum;

import java.util.*;

class Solution {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> indexResult = new HashSet<>();
        Set<List<Integer>> valueResult = new HashSet<>();
        var doubles = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                var current = doubles.getOrDefault(nums[i] + nums[j], new ArrayList<>());
                current.add(List.of(i, j));
                doubles.put(nums[i] + nums[j], current);
            }
        }
        for (int firstKey : doubles.keySet()) {
            var first = doubles.get(firstKey);
            var secondKey = target - firstKey;
            var second = doubles.get(secondKey);
            if (second != null) {
                //System.out.printf("firstKey: %d, secondKey: %d\n", firstKey, secondKey);
                System.out.printf("first: %d, second: %d\n", first.size(), second.size());
                for (List<Integer> firstAttempt : first) {
                    for (List<Integer> secondAttempt : second) {
                        if (!secondAttempt.contains(firstAttempt.get(0)) && !secondAttempt.contains(firstAttempt.get(1))) {
                            var newResult = new ArrayList<Integer>();
                            newResult.addAll(firstAttempt);
                            newResult.addAll(secondAttempt);
                            newResult.sort(Comparator.comparingInt(a -> a));
                            if (!indexResult.contains(newResult)) {
                                indexResult.add(newResult);
                                valueResult.add(newResult.stream()
                                    .map(i -> nums[i]).sorted().toList()
                                );
                            }
                        }
                    }
                }
            }
        }
        var mappedResult = valueResult.stream()
            .toList();
        //System.out.println(indexResult);
        System.out.println(mappedResult);
        return mappedResult;
    }

    public static void main(String[] args) {
        fourSum(new int[] {1,0,-1,0,-2,2}, 0);
        fourSum(new int[] {2,2,2,2,2}, 8);
        fourSum(new int[] {-5,5,4,-3,0,0,4,-2}, 4);
        fourSum(new int[] {-5,5,4,-3,0,0,4,-2}, 4);
        fourSum(new int[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90}, 200);
    }

}