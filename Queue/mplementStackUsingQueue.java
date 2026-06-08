package ImplementStackUsingQueue;

import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private Queue<Integer> queue;

    Solution() {
        this.queue = new ArrayDeque<>();
    }

    // function to push data in stack using queue
    void push(int data) {
        queue.offer(data);
    }

    // check stack is empty or not using queue
    boolean isEmpty() {
        return queue.isEmpty();
    }

    // function to pop data from stack using queue
    int pop() {
        if (isEmpty()) {
            return -1;
        }
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    // function to get the peek element from stack using queue
    int peek() {
        if (isEmpty()) {
            return -1;
        }
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        int temp = queue.poll();
        queue.offer(temp);
        return temp;
    }
}

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        Solution stack = new Solution();

        System.out.println(stack.pop());
        stack.push(2);

        stack.push(3);
        stack.push(7);
        stack.push(4);

    }
}
