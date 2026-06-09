import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {12, 5, 7, 2, 4, 0, 9, 10, 1};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int current = i;
            int last = current - 1;
            while (last != -1) {
                if (nums[last] > nums[current]) {
                    int temp = nums[last];
                    nums[last] = nums[current];
                    nums[current] = temp;
                    current = last;
                } else {
                    break;
                }
                last--;
            }
        }
    }
}
