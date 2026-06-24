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
 * Delete a node without using the head pointer.
 *
 * Idea:
 * Copy the data of the next node into the current node,
 * then bypass the next node.
 *
 * Limitation:
 * This approach works only when the given node is NOT
 * the last node of the linked list.
 */
class SinglyLinkedList {

    private Node head;
    private Node tail;

    SinglyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a new node at the end of the linked list
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

    // Delete a node without using the head pointer
    void deleteNode(Node node) {
      
       if (node == null || node.next == null) {
            return;
       }
        // Copy data from the next node
        node.data = node.next.data;

        // Update tail if the next node is the last node
        if (node.next.next == null) {
            tail = node;
        }

        // Bypass the next node
        node.next = node.next.next;
    }

    void testDeleteOperation() {
        deleteNode(head.next.next);
    }

    // Traverse and print the linked list
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

public class DeleteNodeWithoutUsingHead {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.testDeleteOperation();

        list.display();
    }
}
