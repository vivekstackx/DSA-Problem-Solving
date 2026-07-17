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

   // Insert a new node at the end of the copied list
   Node insertAtEnd(Node head , int data){
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

   // Find the position (step/index) of the target node in the original list
   private int getStep(Node originalHead , Node target){

      if(target == null){
         return -1;
      }

      int step = 0;
      Node curr = originalHead;

      while(curr != null){

         if(curr == target){
            break;
         }

         step++;
         curr = curr.next;
      }

      return step;
   }

   Node cloneList(Node originalHead){

      Node originalCurr = originalHead;
      Node copyHead = null;

      // Step 1: Create a copy of the original list
      while(originalCurr != null){
         copyHead = insertAtEnd(copyHead, originalCurr.data);
         originalCurr = originalCurr.next;
      }

      originalCurr = originalHead;
      Node copyCurr = copyHead;

      // Step 2: Set the random pointers in the copied list
      while(originalCurr != null){

         // Find the position of the random node in the original list
         int step = getStep(originalHead , originalCurr.randomPointer);

         if(step != -1){

            // Move to the same position in the copied list
            Node temp = copyHead;

            while(step > 0){
               temp = temp.next;
               step--;
            }

            // Connect the copied random pointer
            copyCurr.randomPointer = temp;
         }

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

   public static void main(String[] args){

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
