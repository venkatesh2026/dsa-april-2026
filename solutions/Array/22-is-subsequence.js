public class IsSubSequence {

    public static void main(String[] args) {
        String  s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));

    }


    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;
        //we should have a both conditions if at least one fail we need to terminate
        //if we have only sPointer < s.length() if no chars matched leads to infinite loop
        //if we have only tPointer < t.length() ,if all chars matched at start if self then unnecessary we are traveling remaining chars
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length();
    }
}
