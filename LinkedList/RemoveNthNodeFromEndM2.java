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
 * Remove Nth Node From End of Linked List (One Pass)
 *
 * Idea:
 * 1. Move the fast pointer n steps ahead.
 * 2. This creates a gap of n nodes between
 *    the slow and fast pointers.
 * 3. Move both pointers one step at a time.
 * 4. When the fast pointer reaches the last node,
 *    the slow pointer will be just before the node
 *    that needs to be removed.
 *
 * Example:
 * Linked List: 10 -> 20 -> 30 -> 40 -> 50
 * n = 3
 *
 * After moving fast pointer 3 steps:
 *
 * slow = 10
 * fast = 40
 *
 * Move both pointers together:
 *
 * slow = 20, fast = 50
 *
 * Now fast is at the last node.
 * slow is just before the node to delete (30).
 *
 * Result:
 * 10 -> 20 -> 40 -> 50
 *
 * Assumption:
 * 1 <= n <= size of linked list
 *
 * Time Complexity  : O(n)
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

        Node slowPointer = head;
        Node fastPointer = head;

        // Move fast pointer n steps ahead
        while (n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }

        // Special case: remove the head node
        if (fastPointer == null) {
            head = head.next;
            return;
        }

        // Move both pointers while maintaining a gap of n nodes
        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        // Remove the target node
        slowPointer.next = slowPointer.next.next;
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
