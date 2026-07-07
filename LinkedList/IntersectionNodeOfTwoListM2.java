/*
List A ke last node ko headA se connect karo.

List B par Floyd Algorithm chalao.

Cycle ka starting node hi intersection node hoga.

Phir original list restore kar do.

*/
class Node{
   int data;
   Node next;
    Node(int data){
      this.data = data;
      this.next = null;
    }
}


class Solution{
   
  private Node getStartingNodeOfCycle(Node head){
     
     Node slow = head;
     Node fast = head;

     while(fast != null && fast.next != null){
       slow = slow.next;
       fast = fast.next.next;

        if(slow == fast){
          break;
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
    Node getIntersectionNode(Node head1 , Node head2){
      
       if(head1 == null || head2 == null){
         return null;
       }

       Node curr1 = head1;

       while(curr1.next != null){
         curr1 = curr1.next;
       }

       curr1.next = head1; // make cycle

       Node cycleStartNode = getStartingNodeOfCycle(head2);

       curr1.next = null; // restore the orginal list 

       return cycleStartNode;
    }
}


public class Main {
    public static void main(String[] args) {
      
       Node head1 = null;
       head1 = new Node(1);
       head1.next = new Node(2);
       head1.next.next = new Node(3);
       head1.next.next.next = new Node(4);
       head1.next.next.next.next = new Node(5);
       head1.next.next.next.next.next = new Node(6);
       head1.next.next.next.next.next.next = new Node(7);

       Node head2 = null;
       head2 = new Node(8);
       head2.next = new Node(9);
     head2.next.next =  head1.next.next.next.next;

       Node intersectionNode = new Solution().getIntersectionNode(head1, head2);

       if(intersectionNode != null){
          System.out.println(intersectionNode.data);
       }
    }
}
