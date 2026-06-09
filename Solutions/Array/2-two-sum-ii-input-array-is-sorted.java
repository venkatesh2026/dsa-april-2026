import java.util.Arrays;

public class TwoSumSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (target == currentSum) {
                return new int[]{left + 1, right + 1};
            } else if (target > currentSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}