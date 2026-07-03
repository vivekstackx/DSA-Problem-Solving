
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

class Solution {
    public Node segregate(Node head) {
        // code here
     if(head == null){
         return null;
     }
     
       Node zeroHead = null;
       Node oneHead = null;
       Node twoHead = null;
       
       Node zeroTail = null;
       Node oneTail = null;
       Node twoTail = null;  
      
       Node curr = head;
       
       while(curr != null){
           
           if(curr.data == 0){
               
               if(zeroHead == null){
                   zeroHead = curr;
                   zeroTail = curr;
                   curr = curr.next;
                   zeroTail.next = null;
               }
               else{
                   zeroTail.next = curr;
                   zeroTail = curr;
                   curr = curr.next;
                   zeroTail.next = null;
               }
           }
           else if(curr.data == 1){
               
                 if(oneHead == null){
                    oneHead = curr;
                    oneTail = curr;
                   curr = curr.next;
                   oneTail.next = null;
               }
               else{
                   oneTail.next = curr;
                    oneTail = curr;
                   curr = curr.next;
                   oneTail.next = null;
               }
           }
           else if(curr.data == 2){
               
                 if(twoHead == null){
                    twoHead = curr;
                   twoTail = curr;
                   curr = curr.next;
                   twoTail.next = null;
               }
               else{
                   twoTail.next = curr;
                   twoTail = curr;
                   curr = curr.next;
                   twoTail.next = null;
               }
           }
       }
       Node newHead = null;
       
       if(zeroHead != null && oneHead != null && twoHead != null){
           
           zeroTail.next = oneHead;
            oneTail.next = twoHead;
           newHead = zeroHead;
       }
       else if(oneHead == null && twoHead == null){
           newHead = zeroHead;
       }
       else if(zeroHead == null && twoHead == null){
           newHead = oneHead;
       }
      else  if(zeroHead == null && oneHead == null){
            newHead = twoHead;
       }
       else if(twoHead == null){
          zeroTail.next = oneHead;
          newHead = zeroHead;
       }
       else if(oneHead == null){
           zeroTail.next = twoHead;
           newHead = zeroHead;
       }
      else  if(zeroHead == null){
           oneTail.next = twoHead;
           newHead = oneHead;
       }
       
       return newHead;
      
    }
}
