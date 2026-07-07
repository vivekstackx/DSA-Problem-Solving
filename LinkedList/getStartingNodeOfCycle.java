class Node{
   int data;
   Node next;

     Node(int data){
       this.data = data;
       this.next = null;
     }
}

class Solution{
   
     Node getBeginingNodeOfCyle(Node head){
        
          Node slow = head;
          Node fast = head;

          while(fast != null && fast.next != null){

              slow = slow.next;
              fast = fast.next.next;

              if(slow == fast){
                 break; // cycle found
              }
          }
         
         if(fast == null || fast.next == null){
           return null; // no cycle
         }

         slow = head;
         while(slow != fast){
            slow = slow.next;
            fast = fast.next;
         }
         
         return slow;
     }
}

public class Main {
    public static void main(String[] args) {
      
       Node head = null;
       head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       head.next.next.next.next = new Node(5);
       head.next.next.next.next.next = new Node(6);
       head.next.next.next.next.next.next = new Node(7);
       head.next.next.next.next.next.next.next = new Node(8);
       head.next.next.next.next.next.next.next.next = new Node(9);
       head.next.next.next.next.next.next.next.next.next = new Node(10);
       head.next.next.next.next.next.next.next.next.next.next = new Node(11);
       head.next.next.next.next.next.next.next.next.next.next.next = new Node(12);
       head.next.next.next.next.next.next.next.next.next.next.next =  head.next.next.next;


       
       Node startNode = new Solution().getBeginingNodeOfCyle(head);
       System.out.println(startNode.data);


       

    }
}
