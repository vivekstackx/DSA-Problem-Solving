class StackUsingDeque{
   private int[] arr;
   private int front, rear , size; 
    
    StackUsingDeque(int n){
      this.size = n;
      this.arr = new int[n];
      this.front = -1;
      this.rear = -1;
    }
  
  private void insertRear(int data){
      if(isFull()){
        System.out.println("stack overflow !");
        return;
      }
       if(isEmpty()){
         front = rear = 0;
      }
      else{
        rear = (rear + 1) % size;
      }
      arr[rear] = data;
      System.out.println(data + " data pushed in stack.");
      
  }
  private int deleteRear(){
     if(isEmpty()){
       System.out.println("stack underflow !");
       return -1;
     }
     int temp = arr[rear];
     if(rear == front){
      front = rear = -1;
     }
     else{
       rear = (rear - 1 + size) % size;
     }
     return temp;
  }
 private int getRear(){
   if(isEmpty()){
    System.out.println("stack underflow !");
    return -1;
   }
   return arr[rear];
 }
    // function to push data in stack using deque
    void push(int data){
       insertRear(data);
    }
    // function to pop data from stack using deque
    int pop(){
      return deleteRear();
    }
    // function to get the peek data of stack using deque
    int peek(){
       return getRear();
    }
    // function to check stack is empty or not using deque
    boolean isEmpty(){
      return front == -1;
    }
    // function to check wheather the stack is full or not using deque
    boolean isFull(){
      return (rear + 1) % size == front;
    }
    // function to display stack using deque
    void display(){
       if(isEmpty()){
         System.out.println("stack underflow !");
       }
       else{
           for(int i = rear; i != front; i = (i - 1 + size) % size){
             System.out.println( "|" + arr[i] + "|");
           }
             System.out.println( "|" + arr[front] + "|");
    
       }
  
    }
}

public class StackUsingDequeDemo {
    public static void main(String[] args) {
      StackUsingDeque stack = new StackUsingDeque(5);
      stack.push(2);
      stack.push(3);
      stack.push(7);
      stack.push(4);
      stack.push(8);
      stack.push(9);

      stack.display();
    }
}
