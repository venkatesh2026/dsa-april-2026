import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {2, 5, 7, 2, 4, 0, 9, 10, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void selectionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = 0;
            //considering element at index 0 is max so,starting loop from index 1
            for (int j = 1; j < length - i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[length - 1 - i];
            nums[length - 1 - i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }
}
