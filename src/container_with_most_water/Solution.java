package container_with_most_water;

class Solution {
    public static int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int start = 0;
        int end = height.length - 1;
        int currentLength = end - start;
        int currentHeight = Math.min(height[start], height[end]);
        int area = currentLength * currentHeight;
        while (start != end) {
            System.out.printf("%d, %d\n", currentHeight, currentLength);
            int leftHeight = Math.min(height[start + 1], height[end]);
            int rightHeight = Math.min(height[start], height[end - 1]);
            int newHeight;
            if (leftHeight >= rightHeight) {
                start++;
                newHeight = leftHeight;
            } else {
                end--;
                newHeight = rightHeight;
            }
            int newLength = currentLength - 1;
            int newArea = newLength * newHeight;
            area = Math.max(area, newArea);
            currentLength = newLength;
            currentHeight = newHeight;
        }
        System.out.println(area);
        return area;
    }

    public static void main(String[] args) {
        maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        maxArea(new int[] {1, 1});
        maxArea(new int[] {1,8,6,2,5,4,8,25,7});
        maxArea(new int[] {1,3,2,5,25,24,5});

    }
}