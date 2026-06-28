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

  
   void rotateRight(int k){
    
        if(head == null || head.next == null || k == 0){
          return;
        }

        Node tail = head;
        int count = 1;

        while(tail.next != null){
          tail = tail.next;
          count++;
        }
    

        int num = k % count;
        
        if(num <= 0){
          return; // rotation not possible for 0 and negative input 
        }

        int position = count - num;

        Node previous = null;
        Node current = head;

        while(position > 0){

           previous = current;
           current = current.next;
           position--;

        }

        previous.next = null;
        tail.next = head;
        head = current;
      
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
      

        System.out.print("Original List : " );
        list.display();

         list.rotateRight(1);

        System.out.print("Modified List : ");
        list.display();
    }
}
