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
    private ListNode mergeTwoList(ListNode head1 , ListNode head2){

         ListNode curr1 = head1;
         ListNode curr2 = head2;
         ListNode dummyNode = new ListNode(0);
         ListNode tail = dummyNode;

         while(curr1 != null && curr2 != null){

             if(curr1.val <= curr2.val){
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
             }
             else{
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;
             }
         }

        tail.next = curr1 == null ? curr2 : curr1;

        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
         
         if(lists.length == 0){
            return null;
         }

         ListNode head1 = lists[0];

         for(int i = 1; i < lists.length; i++){

             ListNode head2 = lists[i];
             ListNode newHead = mergeTwoList(head1 , head2);
             head1 = newHead;
         }
         return head1;
    }
}
