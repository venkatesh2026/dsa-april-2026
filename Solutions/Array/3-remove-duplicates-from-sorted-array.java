// Welcome to WorkPad
// Start coding here...
import java.util.Arrays;

public class  3-remove-duplicates-from-sorted-array{
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,3,4,4,5,6,6,7};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
