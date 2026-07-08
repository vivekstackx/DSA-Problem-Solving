class Node{
   int data;
   Node next;
    Node(int data){
      this.data = data;
      this.next = null;
    }
}

class Solution{
   
  private Node insertAtBegining(Node newList , int data){
      Node newNode = new Node(data);

       if(newList == null){
         newList = newNode;
         return newList;
       }

       newNode.next = newList;
       newList = newNode;
       return newList;
  }

private Node reverse(Node head){
   
    Node prev = null;
    Node curr = head;
    Node next = null;

    while(curr != null){
       next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
    }

    return prev;
}
   Node addTwoSum(Node list1 , Node list2){
     
       list1 = reverse(list1);
       list2 = reverse(list2);

       Node curr1 = list1;
       Node curr2 = list2;
       int sum = 0;
       int data = 0;
       int carry = 0;
     
      Node newList = null;

       while(curr1 != null || curr2 != null){

          if(curr1 != null && curr2 != null){
             sum = curr1.data + curr2.data + carry;
             if(sum > 9){
               data = sum % 10;
               carry = sum / 10;
              newList = insertAtBegining(newList , data);;
             }
             else{
              newList=  insertAtBegining(newList ,sum);
               carry = 0;
             }
             curr1 = curr1.next;
             curr2 = curr2.next;
          }
          else if(curr1 != null && curr2 == null){
             sum = curr1.data + carry;
             if(sum > 9){
               data = sum % 10;
               carry = sum / 10;
              newList = insertAtBegining(newList ,  data);
             }
             else{
              newList = insertAtBegining(newList , sum);
               carry = 0;
             }
             curr1 = curr1.next;
          }
          else if(curr1 == null && curr2 != null){
            sum = curr2.data + carry;
            if(sum > 9){
               data = sum % 10;
               carry = sum / 10;
             newList =  insertAtBegining(newList , data);
            }
            else{
              newList = insertAtBegining(newList , sum);
               carry = 0;
            }
            curr2 = curr2.next;
          }
       }
       if(carry != 0){
        newList= insertAtBegining(newList , carry);
       }

     return newList;
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

public class Main {
    public static void main(String[] args) {
      
Node list1 = new Node(5);
list1.next = new Node(4);
list1.next.next = new Node(9);
list1.next.next.next = new Node(8);

Node list2 = new Node(3);
list2.next = new Node(7);
list2.next.next = new Node(2);
list2.next.next.next = new Node(6);
list2.next.next.next.next = new Node(1);

       Node newList = new Solution().addTwoSum(list1 , list2);

       new Solution().dis(newList);
       
      
    }
}
