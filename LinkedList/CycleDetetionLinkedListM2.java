import java.util.HashSet;


class Node{
   int data;
   Node next;
    Node(int data){
      this.data = data;
      this.next = null;
    }
}

class Solution {

   // funtion to detect the cycle in the linkedList 
   boolean isCycle(Node head){

       Node curr = head;
       HashSet<Node> visited = new HashSet<>();

       while(curr != null){
         
         if(visited.contains(curr)) {
            return true;  
        }
           visited.add(curr);
           curr = curr.next;
       }

       return false; // cycle not found !
   }
}


class Main{
   public static void main(String[] args){
     Solution list = new Solution();

     Node head = null;

     head = new Node(1);
     head.next = new Node(2);
     head.next.next = new Node(3);
     head.next.next.next = new Node(4);
     head.next.next.next.next = new Node(5);
     head.next.next.next.next.next = new Node(6);
     head.next.next.next.next.next.next = new Node(4);
     head.next.next.next.next.next.next.next = new Node(8);
     head.next.next.next.next.next.next.next.next = new Node(9);
     head.next.next.next.next.next.next.next.next.next = new Node(10);
     head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;


     System.out.println(list.isCycle(head));


    
    
   }
}
