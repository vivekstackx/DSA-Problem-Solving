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
    private Node tail;

    Solution() {
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the end of the linked list.
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // If the list is empty, the new node becomes both head and tail.
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Attach the new node at the end and update the tail.
        tail.next = newNode;
        tail = newNode;
    }

    // Sort a linked list containing only 0s, 1s, and 2s.
    void sortList() {

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        // Count the occurrences of 0s, 1s, and 2s.
        Node current = head;

        while (current != null) {

            if (current.data == 0) {
                zeroCount++;
            } else if (current.data == 1) {
                oneCount++;
            } else {
                twoCount++;
            }

            current = current.next;
        }

        // Overwrite node values in sorted order.
        current = head;

        while (zeroCount > 0) {
            current.data = 0;
            current = current.next;
            zeroCount--;
        }

        while (oneCount > 0) {
            current.data = 1;
            current = current.next;
            oneCount--;
        }

        while (twoCount > 0) {
            current.data = 2;
            current = current.next;
            twoCount--;
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

        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(0);
        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(0);
        list.insertAtEnd(1);

        System.out.println("Before sorting:");
        list.display();

        list.sortList();

        System.out.println("After sorting:");
        list.display();
    }
}
