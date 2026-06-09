import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] result1 = productOfArrayExceptSelf(new int[]{4, 3, 2, 1});
        int[] result2 = productOfArrayExceptSelfTwoPass(new int[]{4, 3, 2, 1});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        //1 ,4, 12,24
    }                                    //6 ,2,1 ,1


    public static int[] productOfArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        for (int left = 1; left < nums.length; left++) {
            leftProduct[left] = leftProduct[left - 1] * nums[left - 1];
        }

        for (int right = nums.length - 2; right >= 0; right--) {
            rightProduct[right] = rightProduct[right + 1] * nums[right + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }

    public static int[] productOfArrayExceptSelfTwoPass(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        for (int left = 1, right = nums.length - 2; left < nums.length; left++, right--) {
            leftProduct[left] = leftProduct[left - 1] * nums[left - 1];
            rightProduct[right] = rightProduct[right + 1] * nums[right + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
