// Welcome to WorkPad
// Start coding here...

public class  2-two-sum-ii---input-array-is-sorted {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {1,2,3,4,5,6},9));
       
    }

    public static int[] twoSum(int[] nums,int target) {
        int left=0,right=nums.length-1;
        while(left < right) {
            int sum = nums[left]+nums[right];
            if(sum == target) {
                return new int[] {left+1,right+1};
            }
            if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
