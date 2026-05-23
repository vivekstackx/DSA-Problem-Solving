import java.util.*;

/*
 ias sawal ka logic av clear nahi h , to iase samjhna parega
*/
class MinStack {

    private Deque<Long> stack;
    private long min;

    MinStack() {
        stack = new ArrayDeque<>();
    }

    void push(int x) {

        if (stack.isEmpty()) {
            stack.push((long)x);
            min = x;
        }
        else if (x >= min) {
            stack.push((long)x);
        }
        else {
            long encoded = 2L * x - min;
            stack.push(encoded);
            min = x;
        }
    }

    int pop() {
        if (stack.isEmpty()) return -1;

        long top = stack.pop();
        int result;

        if (top >= min) {
            result = (int) top;
        }
        else {
            result = (int) min;
            min = 2 * min - top;
        }

        return result;
    }

    int getMin() {
        if (stack.isEmpty()) return -1;
        return (int) min;
    }
}
