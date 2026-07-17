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

   Node cloneList(Node originalHead){

      if(originalHead == null){
         return null;
      }

      // Step 1: Insert each copied node immediately after its original node
      Node originalCurr = originalHead;

      while(originalCurr != null){

         Node copyNode = new Node(originalCurr.data);
         copyNode.next = originalCurr.next;
         originalCurr.next = copyNode;
         originalCurr = originalCurr.next.next;

      }

      // Step 2: Set the random pointers for all copied nodes
      originalCurr = originalHead;

      while(originalCurr != null){

        if(originalCurr.randomPointer != null){
           originalCurr.next.randomPointer = originalCurr.randomPointer.next;
        }
        originalCurr = originalCurr.next.next;
      }

      // Step 3: Separate the original list and the copied list
      originalCurr = originalHead;

      Node copyHead = originalCurr.next;
      Node copyCurr = copyHead;
      Node nextOriginalNode = originalCurr.next.next;

      while(nextOriginalNode != null){

        originalCurr.next = nextOriginalNode;
        copyCurr.next = nextOriginalNode.next;

        originalCurr = originalCurr.next;
        nextOriginalNode = nextOriginalNode.next.next;
        copyCurr = copyCurr.next;

      }

      // Restore the last node of the original list
      originalCurr.next = null;

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

       // Create the original linked list
       Node head = new Node(1);
       head.next = new Node(2);
       head.next.next = new Node(3);
       head.next.next.next = new Node(4);
       head.next.next.next.next = new Node(5);

       // Assign random pointer connections
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
