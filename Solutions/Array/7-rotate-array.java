import java.util.Arrays;

public class RotateArrayByKSteps {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;
        int left = 0, right = n - 1;
        //reverse entire array
        reverse(nums, 0, n - 1);
        //now reverse the first k elements
        reverse(nums, 0, k - 1);
        //now reverse elements from k to n
        reverse(nums, k, n - 1);
    }

    public static void reverse(int nums[], int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}