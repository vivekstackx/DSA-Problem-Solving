
 class Solution{
   
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    
      Solution(int n){
        
        this.arr = new int[n];
        this.front = -1;
        this.rear = -1;
        this.size = n;
      }
      // function to check if queue is empty or not
        boolean isEmpty(){
          return front == -1;
        }
      // function to check if queue is full or not
      boolean isFull(){
        return rear == size - 1;
      }
      // function to push the data in queue
       void push(int data){
          if(isFull()){
            System.out.println("queue overflow !");
            return;
          }
         else if(isEmpty()){
             front = 0;
             rear = 0;
         }
        else{
          rear++;
        }
        arr[rear] = data;
        System.out.println(data + " data pushed in queue.");
       }
      // function to pop the data in queue
      int pop(){
         if(isEmpty()){
           System.out.println("queue underflow !");
           return -1;
         }
        if(front == rear){
          int current = arr[front];
          front = rear = -1;
          return current;
        }
        int current = arr[front];
        front++;
        return current;
      }
    // function to get the front data of queue
     int getFront(){
       if(isEmpty()){
         System.out.println("queue underflow !");
         return -1;
       }
       return arr[front];
     }
    // function to get the rear data of queue 
    int getRear(){
        if(isEmpty()){
         System.out.println("queue underflow !");
         return -1;
       }
       return arr[rear];
    }
  // display the queue
   void display(){
     if(isEmpty()){
       System.out.println("queue underflow !");
       return;
     }
     for(int i = front; i <= rear; i++){
       System.out.print(arr[i] + " ");
     }
     System.out.println();
   }
 }
 
 public class LinearQueueUsingArray{
    public static void main(String[] args){
       Solution queue = new Solution(5);
       
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.pop();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        queue.push(60);
        
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
       
       
    }
 }
