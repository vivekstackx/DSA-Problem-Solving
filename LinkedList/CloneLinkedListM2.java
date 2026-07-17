import java.util.Map;
import java.util.HashMap;

class Node{
   int data;
   Node next;
   Node randomPointer;

      Node(int data){
        this.data = data;
        this.next = null;
        this.randomPointer = null;
      }
}


class Solution {

   private Node tail;
     Solution(){
       this.tail = null;
     }
   
  private Node insertAtEnd(Node head , int data){
      Node newNode = new Node(data);

      if(head == null){
         head = newNode;
         tail = newNode;
         return head;
      }
      tail.next = newNode;
      tail = newNode;
      return head;
   }


   Node cloneList(Node originalHead){
      
         Node originalCurr = originalHead;
         Node copyHead = null;


         while(originalCurr != null){
            copyHead = insertAtEnd(copyHead, originalCurr.data);
            originalCurr = originalCurr.next;
         }

           originalCurr = originalHead;
           Node copyCurr = copyHead;

           Map<Node, Node> map = new HashMap<>();
   
          while(originalCurr != null){
             
             map.put(originalCurr , copyCurr);
             originalCurr = originalCurr.next;
             copyCurr = copyCurr.next;
          }
   
         originalCurr = originalHead;
         copyCurr = copyHead;

         while(originalCurr != null){
          
         copyCurr.randomPointer = map.get(originalCurr.randomPointer);
           originalCurr = originalCurr.next;
           copyCurr = copyCurr.next;
         }

       return copyHead;

   }



    void display(Node head){
        if(head == null){
          return;
        }
        Node curr = head;

        while(curr != null){
           
           System.out.print(curr.data + " : ");
           int random = curr.randomPointer == null ? -1 : curr.randomPointer.data;
           System.out.println(random);
           curr = curr.next;
        }
        System.out.println(); 
    }
}


public class Main {
    public static void main(String[] args) {
        
        // connetion established
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

       // random connetion established
       head.randomPointer = head.next.next;
       head.next.randomPointer = head;
       head.next.next.randomPointer = head.next.next.next.next;
       head.next.next.next.randomPointer = head.next.next;
       head.next.next.next.next.randomPointer = head.next;

       Solution obj = new Solution();

       obj.display(head);
      
       Node copyHead = obj.cloneList(head);

        obj.display(copyHead);

    }
}
