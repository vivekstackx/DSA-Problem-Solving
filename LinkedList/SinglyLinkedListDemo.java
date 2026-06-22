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
    private int countNode;

    SinglyLinkedList() {
        head = null;
        tail = null;
        countNode = 0;
    }
    
    // Add a new node at the Beginning of the linked list 
    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        countNode++;
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
        countNode++;
    }

    // Add a new node at the specific position
    void insertAtPosition(int position, int data) {
        if (position < 1 || position > countNode + 1) {
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        if (position == countNode + 1) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        countNode++;
    }

    // function to delete node from Beginning of linkedlist 
    void deleteFromBeginning(){
        if(head == null){
            System.out.println("Linked List is empty!");
            return;
        }
        if(countNode == 1){
            tail = null;
        }
        head = head.next;
        countNode--;
    }

    // function to delete node from end of the Linklist
    void deleteFromEnd(){
        if(head == null){
            System.out.println("Linked List is empty!");
            return;
        }
        if(countNode == 1){
            head = null;
            tail = null;
        }
        else{
            Node current = head; 
            int count = countNode - 1;
            while(count > 1){
                current = current.next;
                count--;
            }
            tail = current;
            tail.next = null;
        }
        countNode--;
    }

    // function to delete node from specific position of Linklist
    void deleteAtPosition(int position){
        // Invalid position check
        if(position < 1 || position > countNode){
            return;
        }
        if(head == null){
            System.out.println("Linked List is empty!");
            return;
        }

        // delete not from Beginning
        if(position == 1){
            deleteFromBeginning();
            return;
        }

        // delete node from last 
        if(position == countNode){
            deleteFromEnd();
            return;
        }

        // delete node between first and lastnode of linklist
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        countNode--;
    }

    // function to delete entire linklist 
    void deleteEntireList(){
        if(head ==  null){
            System.out.println("Linked List is empty!");
            return;
        }
        head = null;
        tail = null;
        countNode = 0; 
    }

    // Traverse and print all nodes
    void display() {
        System.out.println("Total node : " + countNode);
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
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.insertAtPosition(6 , 100);
        list.insertAtPosition(1, 200);
        list.insertAtPosition(1, 300);
        list.insertAtBeginning(400);
        list.insertAtEnd(500);
        list.insertAtPosition(7 , 600);
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteAtPosition(1);
        list.deleteAtPosition(8);
        list.deleteAtPosition(7);
        list.deleteAtPosition(4);
        list.deleteEntireList();
         
        list.display();
    }
}
