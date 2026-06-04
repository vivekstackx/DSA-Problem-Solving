import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    // M1 : Print and destroy queue data
    void printAndDestroyQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    // M2 : Print and restore queue using extra array
    void printAndRestoreQueue(Queue<Integer> queue) {

        int[] temp = new int[queue.size()];
        int index = 0;

        while (!queue.isEmpty()) {
            int data = queue.poll();
            System.out.print(data + " ");
            temp[index++] = data;
        }

        for (int data : temp) {
            queue.offer(data);
        }

        System.out.println();
    }

    // M3 : Print queue using for-each loop
    void printUsingForEach(Queue<Integer> queue) {

        for (int data : queue) {
            System.out.print(data + " ");
        }

        System.out.println();
    }

    // M4 : Print queue using toString()
    void printUsingToString(Queue<Integer> queue) {
        System.out.println(queue);
    }

    // M5 : Print queue using rotation (No extra space)
    void printUsingQueueRotation(Queue<Integer> queue) {

        int size = queue.size();

        while (size-- > 0) {
            int data = queue.poll();
            System.out.print(data + " ");
            queue.offer(data);
        }

        System.out.println();
    }
}

public class DifferentWaysToPrintBuiltInQueue {

    public static void main(String[] args) {

        Solution obj = new Solution();

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        obj.printAndDestroyQueue(queue);

        // obj.printAndRestoreQueue(queue);
        // obj.printUsingForEach(queue);
        // obj.printUsingToString(queue);
        // obj.printUsingQueueRotation(queue);
    }
}
