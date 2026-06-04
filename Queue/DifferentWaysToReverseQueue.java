import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    // M1 : Reverse Queue Using Array
    void reverseQueueUsingArray(Queue<Integer> queue) {

        int[] temp = new int[queue.size()];
        int index = 0;

        while (!queue.isEmpty()) {
            temp[index++] = queue.poll();
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            queue.offer(temp[i]);
        }
    }

    // M2 : Reverse Queue Using Stack
    void reverseQueueUsingStack(Queue<Integer> queue) {

        Deque<Integer> stack = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    // M3 : Reverse Queue Using Recursion
    void reverseQueueUsingRecursion(Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        }

        int current = queue.poll();

        reverseQueueUsingRecursion(queue);

        queue.offer(current);
    }
}

public class DifferentWaysToReverseQueue {

    public static void main(String[] args) {

        Solution obj = new Solution();

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Before Reverse : " + queue);

        // obj.reverseQueueUsingArray(queue);
        // obj.reverseQueueUsingStack(queue);
        obj.reverseQueueUsingRecursion(queue);

        System.out.println("After Reverse  : " + queue);
    }
}

/*
Different Ways To Reverse Queue

M1 : Reverse Queue Using Array
M2 : Reverse Queue Using Stack
M3 : Reverse Queue Using Recursion

Example:

Queue:
10 20 30 40 50

After Reverse:
50 40 30 20 10

---------------------------------
Time Complexity
---------------------------------

M1 -> O(n)
M2 -> O(n)
M3 -> O(n)

---------------------------------
Extra Space
---------------------------------

M1 -> O(n)
M2 -> O(n)
M3 -> O(n)  // Recursion Call Stack

---------------------------------
Notes
---------------------------------

M1 : Uses an extra array.
M2 : Uses an explicit stack.
M3 : Uses the recursion call stack.
*/
