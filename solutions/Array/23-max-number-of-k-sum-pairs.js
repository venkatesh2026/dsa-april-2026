import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        int i = maxOperations(nums, 3);
        System.out.println(i);
    }

    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (diff == nums[i]) {
                if (map.get(diff) <= 1) {
                    continue;
                }
            }
            if (map.get(nums[i]) == 0) {
                continue;
            }

            if (map.containsKey(diff) && map.get(diff) > 0) {
                count++;
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(diff, map.get(diff) - 1);
            }
        }
        return count;
    }
}
