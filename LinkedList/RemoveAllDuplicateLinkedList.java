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

    // Remove all duplicate nodes from a sorted linked list.
    void removeAllDuplicates() {

        Node previous = null;
        Node current = head;

        // Traverse the linked list.
        while (current != null && current.next != null) {

            // Current node is unique.
            if (current.data != current.next.data) {
                previous = current;
                current = current.next;
            } else {

                // Skip all nodes having the same value.
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }

                // Move to the first node having a different value.
                current = current.next;

                // Duplicate nodes started from the head.
                if (previous == null) {
                    head = current;
                } else {
                    // Connect the last unique node with the next unique node.
                    previous.next = current;
                }
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

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(3);

        System.out.println("Before removing duplicates:");
        list.display();

        list.removeAllDuplicates();

        System.out.println("After removing duplicates:");
        list.display();
    }
}
