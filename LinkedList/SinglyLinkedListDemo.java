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
    }
    
    // Add a new node  at the Beginning of the linked list 
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

        // If linked list is empty
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
    void insertAtPosition(int position , int data){
         
          // invalid position
          if(!(position >= 1 && position <= countNode + 1)){
             return;
          }
           int newPosition = position;
         // create new node 
          Node newNode = new Node(data);

          if(head == null){
              head = newNode;
              tail = newNode;
          }
          else{
             Node temp = head;
              // go to the position
              while(newPosition > 2){
                 temp = temp.next;
                 newPosition--;
              }
              if(position == 1){
                 newNode.next = head;
                 head = newNode;
              }
              else{
                 newNode.next = temp.next;
                 temp.next = newNode;
              }
          }
    
    
       if(position == countNode + 1){
         tail = newNode;
       }
      countNode++;

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

      
    }
}

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.insertAtPosition(6 , 100);
       

         
        list.display();

    }
}
