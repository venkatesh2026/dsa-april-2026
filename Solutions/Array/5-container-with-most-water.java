public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));

    }

    public static int maxArea(int[] nums) {
        int maxArea = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int minHeight = Math.min(nums[left], nums[right]);
            maxArea = Math.max((right - left) * minHeight, maxArea);
            if (nums[left] > nums[right]) {
                right--;
            } else if (nums[left] < nums[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}