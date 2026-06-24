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
 * Find the middle node of a linked list using node count.
 *
 * Idea:
 * 1. Maintain the total number of nodes in the linked list.
 * 2. Compute middle index as count / 2.
 * 3. Traverse from the head to the middle position.
 *
 * Note:
 * For an even number of nodes, this returns the second middle node,
 * which matches the LeetCode requirement.
 *
 * Time Complexity  : O(n/2) ≈ O(n)
 * Space Complexity : O(1)
 */
class Solution {

    private Node head;
    private Node tail;
    private int nodeCount;

    Solution() {
        head = null;
        tail = null;
        nodeCount = 0;
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

        nodeCount++;
    }

    // Return the middle node of the linked list
    Node findMiddleNode() {

        if (head == null) {
            return null;
        }

        int middleIndex = nodeCount / 2;
        Node current = head;

        while (middleIndex > 0) {
            current = current.next;
            middleIndex--;
        }

        return current;
    }
}

class MiddleNodeOfLinkedlistM1 {

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
