class Node{
   int data;
   Node next;

     Node(int data){
      this.data = data;
      this.next = null;
     }
}

class QueueDemo{
   private Node front, rear;
       QueueDemo(){
        this.front = null;
        this.rear = null;
       }

       // insert node in queue 
       void enQueue(int data){
           Node newNode = new Node(data);
           if(isEmpty()){
             front = rear = newNode;
             return;
           }
           rear.next = newNode;
           rear = newNode;
            
       }

       int deQueue(){
          if(isEmpty()){
            return -1;
          }
          int data = front.data;
          if(front == rear){
            front = rear = null;
          }
          else{
            front = front.next;
          }
          return data;
          
       }

       boolean isEmpty(){
         return front == null;
       }
       
       int peek(){
         return isEmpty() ? -1 : front.data;
       }


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




class Main{
   public static void main (String[] args) {
      
       QueueDemo queue = new QueueDemo();

         queue.enQueue(3);
         queue.enQueue(8);
         queue.enQueue(4);
         queue.enQueue(9);
         queue.enQueue(1);

        // System.out.println(queue.peek());
        System.out.println(queue.deQueue());
         System.out.println(queue.deQueue());
          System.out.println(queue.deQueue());
           System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
             System.out.println(queue.deQueue());
    

       queue.display();
   }
}
