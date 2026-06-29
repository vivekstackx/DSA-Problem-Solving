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

        if (head == null) {
            head = newNode;
        } else {

            Node tail = head;

            while (tail.next != null) {
                tail = tail.next;
            }

            tail.next = newNode;
        }
    }

    // Reverse a linked list and return the new head.
    private Node reverse(Node node) {

        Node previousPointer = null;
        Node currentPointer = node;
        Node nextPointer = node;

        while (currentPointer != null) {

            nextPointer = nextPointer.next;

            currentPointer.next = previousPointer;

            previousPointer = currentPointer;
            currentPointer = nextPointer;
        }

        return previousPointer;
    }

    // Check whether the linked list is a palindrome.
    boolean isPalindrome() {

        // Empty list and single node are always palindrome.
        if (head == null || head.next == null) {
            return true;
        }

        Node previous = null;
        Node slowPointer = head;
        Node fastPointer = head;

        // Find the middle of the linked list using Slow & Fast Pointer.
        while (fastPointer != null && fastPointer.next != null) {

            previous = slowPointer;

            slowPointer = slowPointer.next;

            fastPointer = fastPointer.next.next;
        }

        // Split the linked list into two halves.
        previous.next = null;

        // Reverse the second half.
        Node reverseHead = reverse(slowPointer);

        Node left = head;
        Node right = reverseHead;

        boolean flag = true;

        // Compare both halves.
        while (left != null) {

            if (left.data != right.data) {
                flag = false;
                break;
            }

            left = left.next;
            right = right.next;
        }

        // Restore the original linked list.
        Node originalHead = reverse(reverseHead);
        previous.next = originalHead;

        return flag;
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
        list.insertAtEnd(2);
        list.insertAtEnd(1);

        System.out.println(list.isPalindrome());

        list.display();

        System.out.println(list.isPalindrome());

        list.display();

        System.out.println(list.isPalindrome());
    }
}
