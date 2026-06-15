import java.util.Arrays;

public class MoveZerosToEnd {

    /*
    * Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
    * */

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 2, 3, 0, 4};
        moveZerosTwoPass(nums);
        System.out.println(Arrays.toString(nums));


    }

    public static void moveZeros(int[] nums) {
        int nextNonZeroElementIndex = 0;
        // Until non element not found both nextNonZeroElementIndex and i moves together
        // when zero found nextNonZeroElementIndex will wait at zero and will swap with next non zero element at i
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nextNonZeroElementIndex];
                nums[nextNonZeroElementIndex] = nums[i];
                nums[i] = temp;
                nextNonZeroElementIndex++;
            }
        }
    }

    public static void moveZerosWithRestrictedUnnecessarySelfSwap(int[] nums) {
        //since non zero elements move to first ,so taking index 0 as next non zero element index
        //when i found zero, nextNonZeroElementIndex will wait at zero index and when i found next non zero that will swap with nextNonZeroElementIndex
        //when i and nextNonZeroElementIndex pointing to same index position means i did not come across zeros
        int nextNonZeroElementIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nextNonZeroElementIndex) {
                    int temp = nums[nextNonZeroElementIndex];
                    nums[nextNonZeroElementIndex] = nums[i];
                    nums[i] = temp;
                }
                nextNonZeroElementIndex++;
            }
        }
    }

    public static void moveZerosTwoPass(int[] nums) {
        int nextNonZeroElementIndex = 0;

        //fill non zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextNonZeroElementIndex] = nums[i];
                nextNonZeroElementIndex++;
            }
        }
        //fill remaining places wih zeros
        for (; nextNonZeroElementIndex < nums.length; nextNonZeroElementIndex++) {
            nums[nextNonZeroElementIndex] = 0;
        }
    }
}