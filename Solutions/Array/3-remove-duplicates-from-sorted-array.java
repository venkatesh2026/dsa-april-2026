// Welcome to WorkPad
// Start coding here...
import java.util.Arrays;

public class 3-remove-duplicates-from-sorted-array{
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,3,4,4,5,6,6,7,9};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
       int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
