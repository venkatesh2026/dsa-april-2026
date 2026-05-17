import java.util.Arrays;

public class 8-move-zeroes{

    /*
    * Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
    * */

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 3, 0, 4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));


    }

    public static void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast]!=0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}