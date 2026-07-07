public class Solution {
    public ListNode detectCycle(ListNode head) {
        
         ListNode slowPointer = head;
         ListNode fastPointer = head;

         while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                break;
            }
         }

         if(fastPointer == null || fastPointer.next == null){
            return null; // no cycle 
         }

         slowPointer = head;

         while(slowPointer != fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
         }

         return slowPointer;
    }
}
