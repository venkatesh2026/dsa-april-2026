import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LengthOfLongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        if (nums.length == 1) {
            return max;
        }
        Set<Integer> set = Arrays.stream(nums).mapToObj(i -> i).collect(Collectors.toSet());
        for (int num : set) {
            int count = 1;
            if (set.contains(num - 1)) {
                continue;
            }
            int nextElement = num + 1;
            while (set.contains(nextElement)) {
                count++;
                nextElement = nextElement + 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
