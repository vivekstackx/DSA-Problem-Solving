class Node{
   int data;
   Node next;
    Node(int data){
      this.data = data;
      this.next = null;
    }
}


class Solution{
   
    Node getIntersectionNode(Node head1 , Node head2){
      
      int count1 = 0;
      Node curr1 = head1;

      while(curr1 != null){
         count1++;
         curr1 = curr1.next;
      }

      int count2 = 0;
      Node curr2 = head2;
      while(curr2 != null){
        count2++;
        curr2 = curr2.next;
      }

      int diff = Math.abs(count1 - count2);

      curr1 = head1;
      curr2 = head2;

       if(count1 > count2){
         
          while(diff > 0){
             curr1 = curr1.next;
             diff--;
          }
       }
       else if(count2 > count1){
          while(diff > 0){
             curr2 = curr2.next;
             diff--;
          }
       }

       while(curr1 != curr2){
         curr1 = curr1.next;
         curr2 = curr2.next;
       }

       return curr1;
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
