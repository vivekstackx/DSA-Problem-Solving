/*
 * Algorithm Name:
 * Floyd's Cycle Detection Algorithm
 * (Also known as the Tortoise and Hare Algorithm)
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Detects whether the linked list contains a cycle.
    boolean isCycle(Node head) {

        // Initially, both pointers start from the head.
        Node slowPointer = head;
        Node fastPointer = head;

        // Continue until the fast pointer reaches the end of the list.
        while (fastPointer != null && fastPointer.next != null) {

            // Move slow pointer by one step.
            slowPointer = slowPointer.next;

            // Move fast pointer by two steps.
            fastPointer = fastPointer.next.next;

            // If both pointers meet, a cycle exists.
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        // Fast pointer reached the end, so no cycle exists.
        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        // Creates a cycle: 10 -> 4
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;

        System.out.println(solution.isCycle(head));
    }
}
