import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        List<Integer> inputs = Arrays.asList(10, 19, 3, 1, 12, 15, 2);
        for (int i : inputs) {
            obj.push(i);
        }
        obj.pop();
        System.out.println(obj.stack);
        obj.pop();
        System.out.println(obj.stack);
        System.out.println(obj.minStack);
        System.out.println(obj.getMin());
    }

    List<Integer> stack;

    List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int value) {
        stack.add(value);
        if (minStack.size() > 0) {
            minStack.add(Math.min(value, minStack.get(minStack.size() - 1)));
        } else {
            minStack.add(value);
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);

    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }


}
