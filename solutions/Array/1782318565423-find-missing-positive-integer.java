public class FindMissingPositiveInteger {

    public static void main(String[] args) {
        int[] nums = {-10, 3, 2, 6, 9, 1, 4};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            while ((nums[i] >= 1 && nums[i] <= n) && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            i++;
        }

        for (int j = 0; j <n; j++) {
            if (nums[j]!=j+1) {
                return j+1;
            }
        }
        return n+1;
    }
}
