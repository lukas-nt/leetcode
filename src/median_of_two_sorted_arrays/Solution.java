package median_of_two_sorted_arrays;

class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0;
        int right1 = nums1.length - 1;
        int mid1 = (right1 - left1) / 2;

        int left2 = 0;
        int right2 = nums2.length - 1;
        int mid2 = (right2 - left2) / 2;

        boolean found = false;
        int median = nums1[mid1] + nums2[mid2];
        while (!found) {
            int ml1;
            Integer mr1;
            int ml2;
            Integer mr2;

            ml1 = nums1[mid1];
            mr1 = mid1 < nums1.length - 1 ? nums1[mid1 + 1] : null;
            ml2 = nums2[mid2];
            mr2 = mid2 < nums2.length - 1 ? nums2[mid2 + 1] : null;


            boolean moveLeft = mr2 != null && ml1 > mr2;
            boolean moveRight = mr1 != null && ml2 > mr1;
            found = !moveLeft && !moveRight;
            median = nums1[mid1] + nums2[mid2];
            if (left1 < mid1 && mid1 < right1) {
                int moved;
                if (moveLeft) {
                    moved = right1 - mid1;
                    mid2 += moved;
                    right1 = mid1;
                } else {
                    moved = mid1 - left1;
                    mid2 -= moved;
                    left1 = mid1;
                }
                mid1 = left1 + (right1 - left1) / 2;
            } else {
                if (moveLeft) {
                    right2 = mid2;
                } else {
                    left1 = mid1;
                }
            }
        }
        return median;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[] {1,3}, new int[] {2});
        findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
    }
}