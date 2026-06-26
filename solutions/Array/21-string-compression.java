public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int writeIndex = 0;
        while (i < n) {
            int j = i;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            chars[writeIndex++] = chars[i];
            int count = j - i;
            if (count > 1) {
                String countAsString = String.valueOf(count);
                char[] countAsChar = countAsString.toCharArray();
                for (int k = 0; k < countAsChar.length; k++) {
                    chars[writeIndex++] = countAsChar[k];
                }
            }
            i = j;
        }
        return writeIndex;
    }
}
