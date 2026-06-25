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
 * 
 * Remove Nth Node From End of Linked List
 *
 * Idea:
 * 1. Count the total number of nodes in the linked list.
 * 2. Convert the Nth node from the end into a position
 * from the beginning.
 * 3. Traverse to that position and remove the node.
 *
 * Example:
 * Linked List: 10 -> 20 -> 30 -> 40 -> 50
 * n = 3
 *
 * Total Nodes = 5
 * Position From Beginning = 5 - 3 = 2
 *
 * Delete node at index 2 (0-based traversal)
 * Result:
 * 10 -> 20 -> 40 -> 50
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
class Solution {

    private Node head;

    Solution() {
        head = null;
    }

    // Insert a node at the end of the linked list
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

    }

    // Remove the Nth node from the end of the linked list
    void removeNthFromEnd(int n) {

        if (head == null) {
            return;
        }

        // Count total nodes
        int totalNodes = 0;

        Node current = head;

        while (current != null) {
            totalNodes++;
            current = current.next;
        }

        // Validate n
        if (n < 1 || n > totalNodes) {
            return;
        }

        // Convert nth node from end to position from beginning
        int position = totalNodes - n;

        Node currentNode = head;
        Node previousNode = null;

        while (position > 0) {

            previousNode = currentNode;
            currentNode = currentNode.next;
            position--;
        }

        // Delete first node
        if (previousNode == null) {
            head = head.next;
        }
        // Delete middle or last node
        else {
            previousNode.next = currentNode.next;
        }

    }

    // Display the linked list
    void display() {

        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

    }
}

class Main {

    public static void main(String[] args) {

        Solution list = new Solution();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("Original Linked List:");
        list.display();

        list.removeNthFromEnd(3);

        System.out.println("After Removing 3rd Node From End:");
        list.display();
    }

}
