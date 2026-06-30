class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}

class Solution {

    private Node head;

    Solution() {
        this.head = null;
    }

    // Insert a node at the beginning.
    void insertAtBegining(int data) {

        Node newNode = new Node(data);

        // If list is empty, new node becomes head.
        if (head == null) {
            head = newNode;
            return;
        }

        // Connect new node with current head.
        newNode.next = head;
        head.previous = newNode;

        // Move head to the new node.
        head = newNode;
    }

    // Insert a node at the end.
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node tail = head;

        // Reach the last node.
        while (tail.next != null) {
            tail = tail.next;
        }

        // Attach new node after the last node.
        tail.next = newNode;
        newNode.previous = tail;
    }

    // Insert a node at a specific position (1-based indexing).
    void insertAtPosition(int position, int data) {

        // Count total number of nodes.
        int nodeCount = 0;
        Node currentNode = head;

        while (currentNode != null) {
            nodeCount++;
            currentNode = currentNode.next;
        }

        // Check whether position is valid.
        if (position < 1 || position > nodeCount + 1) {
            System.out.println("Invalid Position!");
            return;
        }

        // Insert at first position.
        if (position == 1) {
            insertAtBegining(data);
            return;
        }

        // Insert at last position.
        if (position == nodeCount + 1) {
            insertAtEnd(data);
            return;
        }

        Node current = head;

        // Reach the required position.
        while (position > 1) {
            current = current.next;
            position--;
        }

        Node newNode = new Node(data);

        // Update all four links.
        current.previous.next = newNode;
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous = newNode;
    }

    // Delete node from beginning.
    void deleteAtBegining() {

        if (head == null) {
            System.out.println("list empty!");
            return;
        }

        // Move head to the next node.
        head = head.next;

        // Remove backward connection.
        if (head != null) {
            head.previous = null;
        }
    }

    // Delete node from end.
    void deleteAtEnd() {

        if (head == null) {
            System.out.println("list empty!");
            return;
        }

        // If only one node exists.
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        // Reach the last node.
        while (current.next != null) {
            current = current.next;
        }

        // Remove last node.
        current.previous.next = null;
    }

    // Delete node at a specific position.
    void deleteAtPosition(int position) {

        if (head == null) {
            System.out.println("list empty!");
            return;
        }

        // Count total nodes.
        int nodeCount = 0;
        Node currentNode = head;

        while (currentNode != null) {
            nodeCount++;
            currentNode = currentNode.next;
        }

        // Invalid position.
        if (position < 1 || position > nodeCount) {
            return;
        }

        // Delete first node.
        if (position == 1) {
            deleteAtBegining();
            return;
        }

        // Delete last node.
        if (position == nodeCount) {
            deleteAtEnd();
            return;
        }

        Node current = head;

        // Reach the target node.
        while (position > 1) {
            current = current.next;
            position--;
        }

        // Connect previous node with next node.
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    // Display linked list in forward direction.
    void displayForward() {

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

    // Display linked list in backward direction.
    void displayBackward() {

        if (head == null) {
            System.out.println("Linkedlist empty!");
            return;
        }

        Node current = head;

        // Reach the last node.
        while (current.next != null) {
            current = current.next;
        }

        // Traverse in reverse direction.
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
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
        list.insertAtEnd(4);


        list.deleteAtBegining();
        
       list.deleteAtPosition(2);


        list.displayForward();
        list.displayBackward();
    }
}
