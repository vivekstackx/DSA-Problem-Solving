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
 * Reverse Linked List using an extra linked list.
 *
 * Idea:
 * Traverse the original list and insert each node's data
 * at the beginning of a new linked list.
 *
 * Example:
 * Original: 10 -> 20 -> 30 -> 40
 * Reversed: 40 -> 30 -> 20 -> 10
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */
class Solution {

    private Node head;
    private Node tail;
    private Node reversedHead;

    Solution() {
        head = null;
        tail = null;
        reversedHead = null;
    }

    // Insert a node at the end of the original linked list
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

    // Insert a node at the beginning of the reversed list
    private void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (reversedHead == null) {
            reversedHead = newNode;
        } else {
            newNode.next = reversedHead;
            reversedHead = newNode;
        }
    }

    // Reverse the linked list using an extra list
    void reverse() {

        while (head != null) {
            insertAtBeginning(head.data);
            head = head.next;
        }

        head = reversedHead;
        reversedHead = null;
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

public class ReverseLinkedListM1 {

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
