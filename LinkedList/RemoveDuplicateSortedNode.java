class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    private Node head;

    Solution() {
        this.head = null;
    }

    // Insert a node at the end of the linked list.
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // If the list is empty, make the new node the head.
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node.
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Attach the new node at the end.
        tail.next = newNode;
    }

    // Remove duplicate nodes from a sorted linked list.
    void removeDuplicate() {

        Node previous = null;
        Node current = head;

        while (current != null) {

            // Keep the node if it is the first node or not a duplicate.
            if (previous == null || previous.data != current.data) {
                previous = current;
                current = current.next;
            } else {

                // Skip the duplicate node.
                previous.next = current.next;
                current = current.next;
            }
        }
    }

    // Display the linked list.
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

public class Main {

    public static void main(String[] args) {

        Solution list = new Solution();

        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(4);

        System.out.println("Before removing duplicates:");
        list.display();

        list.removeDuplicate();

        System.out.println("After removing duplicates:");
        list.display();
    }
}
