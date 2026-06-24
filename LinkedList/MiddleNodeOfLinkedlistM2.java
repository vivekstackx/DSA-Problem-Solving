// Node structure
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/*
 * Find the middle node of a linked list using the
 * Slow and Fast Pointer technique.
 *
 * Idea:
 * - Slow pointer moves one step at a time.
 * - Fast pointer moves two steps at a time.
 * - When the fast pointer reaches the end of the list,
 *   the slow pointer will be at the middle node.
 *
 * Note:
 * For an even number of nodes, this returns the
 * second middle node, which matches the LeetCode requirement.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(1)
 */
class Solution {

    private Node head;
    private Node tail;

    Solution() {
        head = null;
        tail = null;
    }

    // Insert a node at the end of the linked list
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Return the middle node of the linked list
    Node findMiddleNode() {

        if (head == null) {
            return null;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}

class MiddleNodeOfLinkedlistM2 {

    public static void main(String[] args) {

        Solution list = new Solution();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        Node middleNode = list.findMiddleNode();

        if (middleNode != null) {
            System.out.println("Middle Node: " + middleNode.data);
        }
    }
}
