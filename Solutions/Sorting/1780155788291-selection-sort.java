import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {2, 5, 7, 2, 4, 0, 9, 10, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxElementIndex = -1;
            int maxElement = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > maxElement) {
                    maxElement = nums[j];
                    maxElementIndex = j;
                }
            }
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = maxElement;
            nums[maxElementIndex] = temp;
        }
    }
}
