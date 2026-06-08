import java.util.Deque;

class Solution {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    // check queue is empty or not
    boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // function to push data in queue
    void push(int data) {
        stack1.push(data);
    }

    // function to pop data from queue
    int pop() {
        if (isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // function to get the front data of queue
    int getFront() {
        if (isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {

        Solution queue = new Solution();

        queue.push(5);
        queue.push(3);
        queue.push(7);
        queue.push(4);
        queue.push(2);
        queue.push(6);


    }
}
