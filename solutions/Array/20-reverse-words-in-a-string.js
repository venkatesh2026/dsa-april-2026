import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseStringContainsWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        s = Arrays.stream(s1).filter(e -> !e.equals("")).
                filter(e -> !e.equals(" ")).collect(Collectors.joining(" "));
        s1 = s.split(" ");

        int left = 0, right = s1.length - 1;

        while (left < right) {
            String temp = s1[left];
            s1[left] = s1[right];
            s1[right] = temp;
            left++;
            right--;
        }
        String collect = Arrays.stream(s1).collect(Collectors.joining(" "));
        return collect;
    }
}
