/*
 ias code me only ye k group node ko hi reverse karta h agar node k se
 kam bachta h last me to uase reverse nahi karega

*/
class Node{
    int data;
    Node next;
     Node(int data){
         this.data = data;
         this.next = next;
     }
}

class Solution{
     
      Node reverseKGroup(Node head , int k){
          
          Node prev = null;
          Node curr = head;
          Node next = null;
          
          Node first = head;
          Node second = null;
          Node newHead = null;
          boolean flag = true;
        
          
          while(curr != null){
              
              int i = k;
              
              while(i > 0 && curr != null){
                  next = curr.next;
                  curr.next = prev;
                  prev = curr;
                  curr = next;
                  i--;
              }
              
              if(flag){
                  newHead = prev;
                  flag = false;
              }
              
              i = k;
              second = curr;
              
              while(i > 1 && second != null && second.next != null){
                  second = second.next;
                  i--;
              }
              
              first.next = second;
              first = curr;
              
             
          }
          
          return newHead;
      }
      
      void dis(Node head){
          if(head == null){
              return;
          }
          
          Node curr = head;
          while(curr != null){
              System.out.print(curr.data + " ");
              curr = curr.next;
          }
          
          System.out.println();
      }
}

class Main{
    public static void main(String[] args){
        
Node head = new Node(1);
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

int k = 5;
         
Node newHead =  new Solution().reverseKGroup(head , k);
         
 new Solution().dis(newHead);
         
    }
}
