import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }
}

class MinStack1 {
    Stack<Integer> stack;
    Stack<Integer> minS;

    public MinStack1() {
        stack = new Stack<Integer>();
        minS = new Stack<Integer>();
    }

    /**
     * 入栈
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (minS.isEmpty()) {
            minS.push(x);
        } else if (minS.peek() >= x) {
            minS.push(x);
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if (tmp == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minS.peek();
    }
}
