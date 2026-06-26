import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {

        int[] temperatures = {89, 105, 70, 58, 47, 47, 46, 76, 100, 70};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int peekElementIndex = stack.pop();
                result[peekElementIndex] = i - peekElementIndex;
            }
            stack.push(i);
        }
        return result;
    }
}