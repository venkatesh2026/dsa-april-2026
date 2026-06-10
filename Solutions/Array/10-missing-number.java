import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int actualSum = Arrays.stream(nums).sum();
        return sum-actualSum;
    }
}
