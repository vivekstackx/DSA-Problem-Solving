class Node{
   int data;
   Node next;

     Node(int data){
       this.data = data;
       this.next = null;
     }
}

class StackDemo{
   private Node top;

      StackDemo(){
         this.top = null;
      }
      // check stack is empty or not 
      boolean isEmpty(){
         return top == null;
      }
      private void insertAtBeginning(int data){
         Node newNode = new Node(data);
         if(isEmpty()){
           top = newNode;
           return;
         }
         newNode.next = top;
         top = newNode;
      }
      private int deleteAtBeginning(){
        if(isEmpty()){
          return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
      }
      // push data into stack
      void push(int data){
        insertAtBeginning(data);
      }

      // pop data from stack 
      int pop(){
       return deleteAtBeginning();
      }

      // get peek data 
      int peek(){
        return isEmpty() ? -1 : top.data;
      }

      void display(){
        System.out.println();
          if(isEmpty()){
            System.out.println("stack empty !");
            return;
          }
          Node curr = top;
          while(curr != null){
             System.out.println(curr.data);
             curr = curr.next;
          }
          System.out.println(); 
        
      }
}


public class Main {
    public static void main(String[] args) {
    
         StackDemo stack = new StackDemo();

        stack.push(10);
        stack.push(33);
        stack.push(3);
        stack.push(8);
        stack.push(12);

        
         stack.display();

    }
}
