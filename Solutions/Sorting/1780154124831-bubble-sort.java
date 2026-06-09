import java.util.Arrays;

public class BubbleSort {

    //in bubble sort each time inner loop move largest or smallest element to end based on condition
    //outer loop need to run n times to move all elements in respective position
    public static void main(String[] args) {
        int[] nums = {5, 7, 2, 4, 0, 9, 10, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void bubbleSort(int[] nums) {
        //need to run outer loop n-1 times because ,by n-1 times itself all elements moved to respective position ,no need to compare first element with remaining
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                //we are comparing current element and next so should run loop till n-1 else index out of bound
                //by end of each iteration largest/smallest element move to end ,so no need to compare that element in next iteration ,so need to run inner loop till n-1-i(iteration count)
                if (compare(nums[j], nums[j + 1]) > 0) {
                    //this compare(nums[j + 1], nums[j]) > 0 move smallest to end in each iteration
                    //this compare(nums[j],nums[j + 1]) > 0 move largest to end in each iteration
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortFlag(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static int compare(int a, int b) {
        return (a - b) > 0 ? 1 : -1;
    }
}
