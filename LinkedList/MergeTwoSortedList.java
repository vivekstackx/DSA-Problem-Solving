class Node{
   int data;
   Node next;
     Node(int data){
       this.data = data;
       this.next = null;
     }
}

class Solution{
    
     Node insertAtEnd(Node head , int data){
        
         Node newNode = new Node(data);
         
         if(head == null){
           head = newNode;
           return head;
         }
         Node current = head;
         while(current.next != null){
           current = current.next;
         }
         current.next = newNode;

         return head;
     }

     Node mergeTwoSortedList(Node list1 , Node list2){
         
         if(list1 == null){
           return list2;
         }
         if(list2 == null){
          return list1;
         }

         Node current1 = list1;
         Node current2 = list2;
         Node tail = null;
         Node newList = null;

         while(current1 != null && current2 != null){
           
             if(current1.data <= current2.data){
                
                 if(tail == null){
                    tail = current1;
                    newList = current1;
                    current1 = current1.next;
                 }
                 else{
                    tail.next = current1;
                    tail = current1;
                    current1 = current1.next;
                 }
                 
             }
             else{
                  if(tail == null){
                    tail = current2;
                    newList = current2;
                    current2 = current2.next;
                  }
                  else{
                      tail.next = current2;
                      tail = current2;
                      current2 = current2.next;
                  }
             }
               tail.next = null;
             
         }

         if(current1 == null){
            tail.next = current2;
         }
         else{
           tail.next = current1;
         }
       
        return  newList;
     }

     void display(Node list){
        if(list == null){
           System.out.println("list empty !");
           return;
        }

        Node current = list;
        while(current != null){
           System.out.print(current.data + " ");
           current = current.next;
        }
        System.out.println();
     }


}

public class Main {
    public static void main(String[] args) {
       Solution list = new Solution();
       
        Node list1 = null;
        Node list2 = null;

      list1 = list.insertAtEnd(list1 , 2);
         list.insertAtEnd(list1 , 4);
         list.insertAtEnd(list1 , 5);
         list.insertAtEnd(list1 , 7);
         

      list2 = list.insertAtEnd(list2 , 3);
         list.insertAtEnd(list2 , 4);
         list.insertAtEnd(list2 , 4);
         list.insertAtEnd(list2 , 6);
         list.insertAtEnd(list2 , 8);
         list.insertAtEnd(list2 , 10);


      list.display(list1);
      list.display(list2);


     Node newList = list.mergeTwoSortedList(list1  , list2);

     list.display(newList);

    }
}
