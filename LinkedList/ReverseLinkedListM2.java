import java.util.Deque;
import java.util.ArrayDeque;

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
 * Reverse Linked List using a Stack.
 *
 * Idea:
 * 1. Traverse the linked list and push all node values into a stack.
 * 2. Traverse the linked list again and replace each node's value
 *    with the value popped from the stack.
 *
 * Example:
 * Original: 10 -> 20 -> 30 -> 40 -> 50
 * Reversed: 50 -> 40 -> 30 -> 20 -> 10
 *
 * Note:
 * This approach reverses the data stored in the nodes,
 * not the actual links between nodes.
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
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

    // Reverse the linked list using a stack
    void reverse() {

        Deque<Integer> stack = new ArrayDeque<>();

        Node current = head;

        // Push all node values into the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;

        // Replace node values with stack values
        while (current != null) {
            current.data = stack.pop();
            current = current.next;
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

public class ReverseLinkedListM2{

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
