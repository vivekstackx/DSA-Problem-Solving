import java.util.Deque;
import java.util.ArrayDeque;

class MyStack {

    private Deque<Integer> queue1;
    private Deque<Integer> queue2;

    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        } else if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (!queue1.isEmpty()) {
            int size = queue1.size();
            while (size > 1) {
                queue2.offer(queue1.poll());
                size--;
            }
            return queue1.poll();
        } else {
            int size = queue2.size();
            while (size > 1) {
                queue1.offer(queue2.poll());
                size--;
            }
            return queue2.poll();
        }
    }

    public int top() {
        if (empty()) {
            return -1;
        }

        if (!queue1.isEmpty()) {
            int size = queue1.size();
            while (size > 1) {
                queue2.offer(queue1.poll());
                size--;
            }
            int temp = queue1.poll();
            queue2.offer(temp);
            return temp;
        } else {
            int size = queue2.size();
            while (size > 1) {
                queue1.offer(queue2.poll());
                size--;
            }
            int temp = queue2.poll();
            queue1.offer(temp);
            return temp;
        }
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

   
}

public class ImplementStackTwoQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
       
      
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
