class QueueUsingDeque{
   private int[] arr;
   private int front, rear, size;

    QueueUsingDeque(int n){
      this.size = n;
      this.arr = new int[n];
      this.front = -1; 
      this.rear = -1;
    }
    private void insertRear(int data){
       if(isFull()){
         System.out.println("queue overflow !");
         return;
       }
       else if(isEmpty()){
         front = rear = 0;
       }
       else{
         rear = (rear + 1) % size;
       }
       arr[rear] = data;
       System.out.println(data + " data pushed in queue.");
    }
  private int deleteFront(){
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
  private int getFrontOfDeque(){
     if(isEmpty()){
       System.out.println("queue underflow !");
       return -1;
     }
     return arr[front];
  }
  private int getRearOfDeque(){
     if(isEmpty()){
       System.out.println("queue underflow !");
       return -1;
     }
     return arr[rear];
  }
  // function to check queue is empty or not 
   boolean isEmpty(){
     return front == -1;
   }
   // function to check queue is full or not 
   boolean isFull(){
     return (rear + 1) % size == front;
   }
    // function to push data in queue using deque 
     void enQueue(int data){
       insertRear(data);
     }
     // function to pop data from queue using deque
     int deQueue(){
       return deleteFront();
     }
     // function to get the front data of queue using deque
     int getFront(){
       return getFrontOfDeque();
     }
     // function to get the rear data of queue using deque
     int getRear(){
       return getRearOfDeque();
     }
     // function to display the queue 
     void display(){
       if(isEmpty()){
       System.out.println("queue underflow !");
       return;
     }
    
      for(int i = front; i != rear; i = (i + 1) % size){
         System.out.print("|" + arr[i]+ "|");
      }
      System.out.println(arr[rear] + "|");
     }
}

public class QueueUsingDequeDemo {
    public static void main(String[] args) {
       QueueUsingDeque queue = new QueueUsingDeque(5);
       queue.enQueue(4);
       queue.enQueue(3);
       queue.enQueue(7);
       queue.enQueue(8);
       queue.enQueue(1);

    
       System.out.println(queue.deQueue());

       queue.display();
    }
}
