import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int left = 0;
        int max = 0;
        int count = 0;

        for (int right = 0; right < s.length(); ) {
            boolean isAdded = map.add(s.charAt(right));
            if (isAdded) {
                count++;
                right++;
            } else {
                map.remove(s.charAt(left));
                left++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
