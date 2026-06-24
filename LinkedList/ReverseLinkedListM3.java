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
 * My Observation:
 *
 * Current node me previous node ka address aayega,
 * lekin usse pahle next node ka reference save karna padega,
 * nahi to remaining linked list ka reference kho jayega.
 */

/*
 * Reverse Linked List using three pointers.
 *
 * Idea:
 * Each node should point to its previous node.
 * Before changing the current node's next reference,
 * we must save the next node; otherwise, the remaining
 * part of the linked list would become inaccessible.
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

    // Reverse the linked list
    void reverse() {

        tail = head;

        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {

            next = current.next;      // Save next node
            current.next = previous;  // Reverse current link
            previous = current;       // Move previous forward
            current = next;           // Move current forward
        }

        head = previous;
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

class ReverseLinkedListM3 {

    public static void main(String[] args) {

        Solution list = new Solution();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.println("Original Linked List:");
        list.display();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.display();
    }
}
