// node structure
class Node {
     int data;
    Node next;

     Node(int data){
      this.data = data;
      this.next = null;
     }

}

class SinglyLinkedList {

    private Node head;
    private Node tail;

    SinglyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a new node at the end of the linked list
    void addNode(int data) {

        Node newNode = new Node(data);

        // If linked list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Traverse and print all nodes
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
    }
}

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);

        list.display();
    }
}
