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
        head = null;
    }

    // Insert a node at the end of the linked list
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    /**
     * Removes every kth node from the linked list.
     *
     * Example:
     * Input : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, k = 3
     * Output: 1 -> 2 -> 4 -> 5 -> 7
     *
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    void removeEveryKth(int k) {

        if (head == null || k <= 0) {
            return;
        }

        if (k == 1) {
            head = null;
            return;
        }

        Node previous = null;
        Node current = head;
        int count = 1;

        while (current != null) {

            if (count == k) {

                previous.next = current.next;
                current = current.next;
                count = 1;

            } else {

                previous = current;
                current = current.next;
                count++;
            }
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

public class RemoveEveryKthNodeOfLinkedList {

    public static void main(String[] args) {

        Solution list = new Solution();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.insertAtEnd(11);

        System.out.print("Original List : ");
        list.display();

        list.removeEveryKth(3);

        System.out.print("Modified List : ");
        list.display();
    }
}
