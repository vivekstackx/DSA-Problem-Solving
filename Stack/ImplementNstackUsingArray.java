import java.util.ArrayDeque;
import java.util.Deque;

class Node{
  int dataIndex;
  Node next;
    Node(int dataIndex){
      this.dataIndex = dataIndex;
      this.next = null; 
    }
}

class ArrayStorage{
    private int[] arr;
    private Node[] stackArr;
    private Deque<Integer> emptySlotStack;


    ArrayStorage(int size , int totalStack){
      this.arr = new int[size];
      this.stackArr = new Node[totalStack];
      this.emptySlotStack = new ArrayDeque<>();

      for(int i = 0; i < totalStack; i++){
        stackArr[i] = null;
      }

      for(int i = 0; i < size; i++){
        emptySlotStack.push(i);
      }

    }

    // function to push data in specific stack 
    void push(int stackNo , int data){
       
         if(isFull()){
           System.out.println("Array Storage full !");
           return;
         }

         int stackNumber = stackNo - 1;

         int emptySlot = emptySlotStack.pop();
         arr[emptySlot] = data;
         Node newNode = new Node(emptySlot);

         newNode.next = stackArr[stackNumber];
         stackArr[stackNumber] = newNode;

    }
    // function to pop data from specific stack 
    int pop(int stackNo){

        int stackNumber = stackNo - 1;

        if(isEmpty(stackNumber)){
           System.out.println("stack " + stackNo + " empty !");
           return -1;
        }
        int emptySlot = stackArr[stackNumber].dataIndex;
        int data = arr[emptySlot];
        emptySlotStack.push(emptySlot);
        stackArr[stackNumber] = stackArr[stackNumber].next;
        
        return data;
        
    }
    // function to check specific stack is empty or not
    boolean isEmpty(int stackNumber){
       return stackArr[stackNumber] == null;
    }
    // function to check array storage is full or not 
    boolean isFull(){
      return emptySlotStack.isEmpty();
    }
    // function to get the peek data of specific stack 
    int peek(int stackNo){

        int stackNumber = stackNo - 1;

        if(isEmpty(stackNumber)){
           System.out.println("stack " + stackNo + " empty !");
           return -1;
        }

        return arr[stackArr[stackNumber].dataIndex];
    }

   // function to display all stack
   void display(){

      for(int i = 0; i < stackArr.length; i++){

           int stackNumber = i;
           if(isEmpty(stackNumber)){
              System.out.println("stack " + (stackNumber + 1) + " empty !");
           }
           else{
               System.out.println("stack " + (stackNumber + 1) + " is : ");
               Node curr = stackArr[stackNumber];
               while(curr != null){
                  int emptySlot = curr.dataIndex;
                 System.out.println(arr[emptySlot]);
                 curr = curr.next;
               }
               System.out.println();
           }
      }
   }


}


class Main{
  public static void main (String[] args) {
     
     int size = 11;
     int totalStack = 3;

     ArrayStorage storage = new ArrayStorage(size , totalStack);

      storage.push(1 , 10); 
      storage.push(1 , 12);
      storage.push(1 , 32);
      storage.push(3 , 7);
      storage.push(2 , 6);
      storage.push(2 , 9);
      storage.push(3 , 11);
      storage.push(1 , 18);
      storage.push(2 , 5);
      storage.push(1 , 8);
      storage.push(3 , 22);
      storage.push(3 , 3);

     System.out.println(storage.pop(1));
    System.out.println(storage.peek(1));
     System.out.println(storage.peek(2));
 System.out.println(storage.peek(3));
 

     storage.display();

  }
}
