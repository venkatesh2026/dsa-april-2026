import java.util.HashMap;
import java.util.Map;

public class SubArrayWithMaximumSum {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //if current value greater than sum of(currentSum,currentValue) then need to reset subarray starting position,
            //else expand substring
            if (nums[i] > (nums[i] + currentSum)) {
                currentSum = nums[i];
            } else {
                currentSum = currentSum + nums[i];
            }
            //maximum = Math.max(maximum, currentSum);
            if (currentSum > maximum) {
                maximum = currentSum;
                //here i will be the max sub array end position
            }
        }
        return maximum;
    }
}