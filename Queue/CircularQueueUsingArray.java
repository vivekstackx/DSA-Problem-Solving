class Solution{
  private int front, rear, size;
  private int[] arr;
  
   Solution(int n){
    this.size = n;
     this.front = -1;
     this.rear = -1;
     this.arr = new int[n];
   }
   // function to check queue is full or not 
    boolean isFull(){
      return (rear + 1) % size == front;
    }
    // function to check queue is empty or not 
    boolean isEmpty(){
      return front == -1;
    }
   // function to push data in circular queue
    void enqueue(int data){
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
        System.out.println(data + " data pushed.");
    }
    // function to pop data from circular queue 
    int dequeue(){
       if(isEmpty()){
        System.out.println("queue underflow !");
        return -1;
       }
       int temp = arr[front];
       if(front == rear){
         front = rear = -1; // reset
       }
       else{
         front = (front + 1) % size;
       }
       return temp;
    }
    // function to get the front data 
    int getFront(){
      if(isEmpty()){
        System.out.println("queue underflow !");
        return -1;
      }
      return arr[front];
    }
    // function to get the rear data
    int getRear(){
    if(isEmpty()){
        System.out.println("queue underflow !");
        return -1;
      }
      return arr[rear];
    }
    // function to display circular queue
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




public  class CircularQueueUsingArray {
    public static void main(String[] args) {
      Solution queue  = new Solution(7);
    
         
    } 

}
