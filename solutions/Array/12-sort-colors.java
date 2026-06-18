import java.util.Arrays;

public class SortColoursThoseRepresentsZerosOnceAndTwos {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        sortColoursSinglePass(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortColorsCountApproach(int[] nums) {

        int zerosCount = 0, onceCount = 0, twosCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosCount++;
            } else if (nums[i] == 1) {
                onceCount++;
            } else {
                twosCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zerosCount > 0) {
                nums[i] = 0;
                zerosCount--;
            } else if (onceCount > 0) {
                nums[i] = 1;
                onceCount--;
            } else {
                nums[i] = 2;
                twosCount--;
            }
        }
    }

    // in first pass move zeros to starting
    //in second pass move 1's after zeros
    public static void sortColoursWithTwoPointerAndTwoPass(int[] nums) {
        int nextZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i != nextZeroIndex) {
                    int temp = nums[nextZeroIndex];
                    nums[nextZeroIndex] = nums[i];
                    nums[i] = temp;
                }
                nextZeroIndex++;
            }
        }

        int nextOneIndex = nextZeroIndex;
        for (int i = nextZeroIndex; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i != nextOneIndex) {
                    int temp = nums[nextOneIndex];
                    nums[nextOneIndex] = nums[i];
                    nums[i] = temp;
                }
                nextOneIndex++;
            }
        }
    }

    public static void sortColoursSinglePass(int[] nums) {
        int zerosIndex = 0, twosIndex = nums.length - 1;

        int i = 0;

        while (i <= twosIndex) {

            if (nums[i] == 0) {
                if (i != zerosIndex) {
                    int temp = nums[i];
                    nums[i] = nums[zerosIndex];
                    nums[zerosIndex] = temp;
                }
                zerosIndex++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                while (i <= twosIndex && nums[twosIndex] == 2) {
                    twosIndex--;
                }
                if (i <= twosIndex) {
                    int temp = nums[i];
                    nums[i] = nums[twosIndex];
                    nums[twosIndex] = temp;
                    twosIndex--;
                }
            }
        }
    }
}
