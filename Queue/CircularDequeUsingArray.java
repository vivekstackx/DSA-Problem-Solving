class Solution{
   private int front, rear, size;
   private int[] arr;

   Solution(int n){
     this.size = n;
     this.arr = new int[n];
     this.front = -1;
     this.rear = -1;
   }
   // function to check Deque is full or not
   boolean isFull(){
     return (rear + 1) % size == front;
   }
   // function to check Deque is empty or not 
   boolean isEmpty(){
     return front == -1;
   }
   // function to insert data in Deque from rear
   void insertLast(int data){
      if(isFull()){
        System.out.println("Deque overflow !");
        return;
      }
      if(isEmpty()){
        front = rear = 0;
      }
      else{
        rear = (rear + 1) % size;
      }
      arr[rear] = data;
      System.out.println(data + " data pushed.");
   }
   // function to delete data in Deque from front
   int deleteFront(){
      if(isEmpty()){
        System.out.println("queue underflow !");
        return -1;
      }
      int temp = arr[front];
      if(front == rear){
        front = rear = -1;
      }
      else{
        front = (front + 1) % size;
      }
      return temp;
   }
   // function to insert data in Deque from front 
   void insertFront(int data){
     if(isFull()){
       System.out.println("Queue overflow !");
       return;
     }
     if(isEmpty()){
       front = rear = 0;
     }
     else{
       front = (front - 1 + size) % size;
     }
     arr[front] = data;
     System.out.println(data + " data pushed.");
   }
   // function to delete data in Deque from rear
    int deleteRear(){
       if(isEmpty()){
         System.out.println("Deque underflow !");
         return -1;
       }
       int temp  = arr[rear];
         if(rear == front){
          front = rear = -1;
       }
       else{
         rear = (rear - 1 + size) % size;
       }
       return temp;
    }
    // function to get the front data in Deque
      int getFront(){
        if(isEmpty()){
          System.out.println("Deque underflow !");
          return -1;
        }
        return arr[front];
     }
    // function to get the rear data in Deque
     int getRear(){
        if(isEmpty()){
           System.out.println("Deque underflow !");
           return -1;
        }
        return arr[rear];
     }
     // function to display Deque
    void display(){
      if(isEmpty()){
        System.out.println("queue underflow !");
      }
      else{
          System.out.print("[");
          for(int i = front; i != rear; i = (i + 1) % size){
             System.out.print(arr[i] + " ");
          }
          System.out.print(arr[rear]);
          System.out.println("]");
      }
    }
    
}


public class CircularDequeUsingArray {
    public static void main(String[] args) {
      Solution Deque = new Solution(10);
       Deque.insertLast(4);
       Deque.insertLast(9);
       Deque.insertLast(7);
       Deque.insertLast(0);
       Deque.insertLast(5);
       Deque.insertLast(2);
       Deque.insertLast(3);

       Deque.insertFront(9);
       Deque.insertFront(1);
       Deque.insertLast(4);
     
      System.out.println(Deque.deleteFront());
      System.out.println(Deque.deleteFront());
      System.out.println(Deque.deleteRear());
      System.out.println(Deque.deleteRear());
     
    
       Deque.display();

    }
}
