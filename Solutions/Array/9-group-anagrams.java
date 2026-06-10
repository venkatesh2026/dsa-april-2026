import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(input);
        System.out.println(lists);

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String input : strs) {
            int[] frequency = new int[26];
            for (char c : input.toCharArray()) {
                int index = c - 'a';
                frequency[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : frequency) {
                sb.append("#");
                sb.append(num);
            }
            String key = sb.toString();
            List<String> list = result.getOrDefault(key, new ArrayList<>());
            list.add(input);
            result.put(key, list);
        }
        return new ArrayList<>(result.values());
    }
}
