class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Counts the total number of nodes present in the cycle.
    int countCircularNode(Node head) {

        Node slowPointer = head;
        Node fastPointer = head;
        boolean cycleFound = false;

        // Detect cycle using Floyd's Cycle Detection Algorithm.
        while (fastPointer != null && fastPointer.next != null) {

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                cycleFound = true;
                break;
            }
        }

        // If a cycle exists, count the nodes in the cycle.
        if (cycleFound) {

            int cycleNodeCount = 1;
            slowPointer = slowPointer.next;

            while (slowPointer != fastPointer) {
                cycleNodeCount++;
                slowPointer = slowPointer.next;
            }

            return cycleNodeCount;
        }

        // No cycle found.
        return 0;
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

        // Create a cycle: 10 -> 4
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;

        System.out.println(solution.countCircularNode(head));
    }
}
