// Welcome to WorkPad
// Start coding here...
import java.util.*;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        // Your code here
        int[] nums = {1,0,2,3,4,0,5,0,8,9};
        moveZerosSinglePass(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
        int k = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[k]=nums[i];
                k++;
            }
        }
        for(;k<nums.length;k++){
            nums[k]=0;
        }
    }

        public static void moveZerosSinglePass(int[] nums) {
        int k = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]!=0) {
                //if already in place no need to do self swap
                if(i!=k) {
                    int temp = nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                }
                k++;
            }
        }
    }
}
