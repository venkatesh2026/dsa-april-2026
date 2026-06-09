import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*    Given an array of integers nums and an integer target,
     return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    * */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15,-2};
        int target = 5;
        System.out.println("twoSumBrueForce():"+Arrays.toString(twoSumBrueForce(nums, target)));
        System.out.println("twoSumOptimal():"+Arrays.toString(twoSumOptimal(nums, target)));
    }

    //brute force
    public static int[] twoSumBrueForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    //optimal

    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}