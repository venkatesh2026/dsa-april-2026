public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        //in best case the word with less no of characters will be the prefix,so get that word
        String s = strs[0];
        int noOfCharsMatching = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (String s1 : strs) {
                if (s1.length() > i) {
                    if (s1.charAt(i) == s.charAt(i)) {
                        count++;
                    }
                } else {
                    break;
                }
            }
            if (count == strs.length) {
                noOfCharsMatching++;
            } else {
                break;
            }
        }
        return noOfCharsMatching > 0 ? s.substring(0, noOfCharsMatching) : "";
    }
}
