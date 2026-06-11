import java.util.Arrays;

public class SortColoursThoseRepresentsZerosOnceAndTwos {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {

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
}
