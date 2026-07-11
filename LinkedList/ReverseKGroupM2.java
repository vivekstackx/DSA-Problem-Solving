/*
maine ias problem ko total 4 pointer ke use se solve kiya h -->
Maine ise kuch is tarah samjha:

1) kth node find karo.
2) kth.next = null karke current group ko alag linked list bana do.
3) Us chhoti linked list par normal reverse algorithm chala do.
4) Reverse hone ke baad dobara original list se connect kar do.
5) Agle group ke liye same process repeat karo.
*/

class Solution {

    private ListNode  getKthNode(ListNode groupPrev, int k){
       
        ListNode kth = groupPrev;

        while(k > 0 && kth != null){
            kth = kth.next;
            k--;
        }

        return kth;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummyNode = new ListNode(0);

        ListNode groupPrev = dummyNode;
        ListNode groupNext = head;
        ListNode start = null;
        ListNode kth = null;

        dummyNode.next = head;
        ListNode newHead = head;
        boolean flag = true;

        while(groupNext != null){

            kth = getKthNode(groupPrev , k);
            // if kth node is not exit
            if(kth == null){
              return newHead;
            }
            else{
                if(flag){
                    newHead = kth;
                    flag = false;
                }
            }

            groupNext = kth.next;
            kth.next = null;
            start = groupPrev.next;

            // reverse current group list
            ListNode prev = null;
            ListNode curr = start;
            ListNode next = null;

            while(curr != null){

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = kth;
            start.next = groupNext;
            groupPrev = start;
        }
         
     return newHead;

    }
}
