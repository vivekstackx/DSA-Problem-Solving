class Node{
   int data;
   Node next;
   Node bottom;
     Node(int data){
       this.data = data;
       this.next = null;
       this.bottom = null; 
     }
}

class Solution{

 private Node mergeTwoList(Node list1 , Node list2){
     
     Node curr1 = list1;
     Node curr2 = list2;

     Node dummyNode = new Node(0);
     Node tail = dummyNode;

     while(curr1 != null && curr2 != null){

        if(curr1.data <= curr2.data){
          tail.bottom = curr1;
          tail = curr1;
          curr1 = curr1.bottom;
        }
        else{
          tail.bottom = curr2;
          tail = curr2;
          curr2 = curr2.bottom;
        }
       
     }
  
   tail.bottom = curr1 == null ? curr2 : curr1;
   return dummyNode.bottom;
     
  }
  

  Node flatteningList(Node root){
     if(root == null){
      return null;
     }

     Node head1 = root;
     Node head2 = root.next;
     root.next = null;
     Node next = null;

     while(head2 != null){

     head1 = mergeTwoList(head1 , head2);
       
       next = head2.next;
       head2.next = null;
       head2 = next;

     }

     return head1;
  }
   
   void display(Node head){
    if(head == null){
      return;
    }

    Node curr = head;
    while(curr != null){
       System.out.print(curr.data + " ");
       curr = curr.bottom;
    }
    System.out.println();
   }
}

public class Main {
    public static void main(String[] args) {
      
       Node head = null;

       head = new Node(5);
       head.bottom = new Node(7);
       head.bottom.bottom = new Node(8);
       head.bottom.bottom.bottom = new Node(30);

       head.next = new Node(10);
       head.next.bottom = new Node(20);
       head.next.bottom.bottom = new Node(40);

       head.next.next = new Node(19);
       head.next.next.bottom = new Node(22);
       head.next.next.bottom.bottom = new Node(50);

       head.next.next.next = new Node(28);
       head.next.next.next.bottom = new Node(35);
       head.next.next.next.bottom.bottom = new Node(40);
       head.next.next.next.bottom.bottom.bottom = new Node(45);

       head.next.next.next.next = new Node(30);
       head.next.next.next.next.bottom =  new Node(34);
       head.next.next.next.next.bottom.bottom = new Node(40);

       Node newHead = new Solution().flatteningList(head);

       new Solution().display(newHead);

    }
}
