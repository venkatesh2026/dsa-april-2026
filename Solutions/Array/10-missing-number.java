import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        // System.out.println(missingNumber(nums));
        System.out.println(missingNumberUsingBitwiseOperatorXOR(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return sum - actualSum;
    }

    public static int missingNumberUsingBitwiseOperatorXOR(int[] nums) {
        int xor1 = 0;
        for (int i = 1; i <= nums.length; i++) {
            xor1 = xor1 ^ i;
        }

        int xor2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor2 = xor2 ^ nums[i];
        }
        return xor1 ^ xor2;
    }
}