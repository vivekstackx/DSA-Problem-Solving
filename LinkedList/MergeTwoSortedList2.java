/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode head;
    private ListNode tail;

        Solution(){
          this.head = null;
          this.tail = null;
        }

    // function to add the node at the end of the list 
     private void insertAtEnd(int data){
         ListNode newNode = new ListNode(data);

         if(head == null){
            head  = newNode;
            tail = newNode;
            return;
         }
         tail.next = newNode;
         tail = newNode;
     }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
         if(list1 == null){
            return list2;
         }

         if(list2 == null){
            return list1;
         }

        ListNode current1 = list1;
        ListNode current2 = list2;

        while(current1 != null && current2 != null){

             if(current1.val < current2.val){
                 insertAtEnd(current1.val);
                 current1 = current1.next;
             }
             else{
                 insertAtEnd(current2.val);
                 current2 = current2.next;
             }
        }

        if(current1 == null){
            tail.next = current2;
        }
        else{
            tail.next = current1;
        }

       return head;  
    }
}
