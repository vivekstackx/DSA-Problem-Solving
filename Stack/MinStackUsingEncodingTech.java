import java.util.*;

/*
 ias sawal ka logic av clear nahi h , to iase samjhna parega
*/

/*
Min Stack (Single Stack Encoding Approach)

Note:
This solution uses encoding technique to store minimum efficiently in O(1) space (extra stack not used).

Concept is partially understood.
Will revisit the logic of encoding (2*x - min) for deeper understanding.
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
