class Node{
   int data;
   Node prev;
   Node next;

     Node(int data){
       this.data = data;
       this.next = null;
       this.prev = null;
     }
}

class DequeDemo{
    private Node front, rear;

      DequeDemo(){
        this.front = null;
        this.rear = null;
      }
      // check Dqueue is empty or not 
       boolean isEmpty(){
         return front == null;
       }
     
     // function to insert node at the front of the Dqueue
      void insertAtFront(int data){
         Node newNode = new Node(data);
          if(isEmpty()){
            front = rear = newNode;
            return;
          }
          newNode.next = front;
          front.prev = newNode;
          front = newNode;
      }
      
    // function to insert node at the rear of the Dqueue
    void insertAtRear(int data){
       Node newNode = new Node(data);
       if(isEmpty()){
         front = rear = newNode;
         return;
       }
       rear.next = newNode;
       newNode.prev = rear;
       rear = newNode;
    }
    // function to delete node at front of the Dqueue
    int deleteAtFront(){
       if(isEmpty()){
         return -1;
       }
       int frontData = front.data;
       if(front == rear){
         front = rear = null;
       }
       else{
           front = front.next;
           front.prev = null;
       }
       return frontData;
    }
    // function to delete node at the end of the Dqueue
    int deleteAtRear(){
       if(isEmpty()){
         return -1;
       }
       int rearData = rear.data;
        if(rear == front){
           front = rear = null;
        }
        else{
           rear = rear.prev;
           rear.next = null;
        }
        return rearData;
    }
    // function to get the front data of the Dqueue
    int getFront(){
      return isEmpty() ? -1 : front.data;
    }
    // function to get the rear data of the Dqueue
    int getRear(){
       return isEmpty() ? -1 : rear.data;
    }

    // Display all elements from front to rear
    void display(){

       if(isEmpty()){
         System.out.println("queue empty !");
         return;
       }
       Node curr = front;
       while(curr != null){
         System.out.print(curr.data + " ");
         curr = curr.next;
       }
       System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
    
      DequeDemo dQueue = new  DequeDemo();

       dQueue.insertAtFront(3);
       dQueue.insertAtFront(8);
       dQueue.insertAtFront(4);
       dQueue.insertAtFront(2);
       dQueue.insertAtRear(9);
       dQueue.insertAtRear(6);
   
      System.out.println(dQueue.deleteAtFront());
        
       
        dQueue.display(); 
    }
}
