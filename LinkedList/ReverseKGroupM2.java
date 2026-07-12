/*
maine ias problem ko total 4 pointer ke use se solve kiya h -->
Maine ise kuch is tarah samjha:

1) kth node find karo.
2) kth.next = null karke current group ko alag linked list bana do.
3) Us chhoti linked list par normal reverse algorithm chala do.
4) Reverse hone ke baad dobara original list se connect kar do.
5) Agle group ke liye same process repeat karo.
*/

/*
 **Reverse Nodes in k-Group (LeetCode #25 - Hard)**

Aaj maine is problem ko solve karte waqt ek alag tarike se socha.

Maine sabse pehle apne aap se ek simple sawal poocha:

**"Mujhe har k-group ko reverse karna hai... lekin reverse linked list to mujhe pehle se hi karna aata hai."**

Bas yahi se idea aaya.

Maine socha agar har k-group ko temporarily ek independent linked list bana diya jaye, 
to fir us par wahi normal reverse algorithm laga sakte hain jo hame already aata hai.

Agar ek group sahi se reverse ho gaya, to aadha problem wahi solve ho gaya.

Uske baad sirf us reversed group ko baaki linked list se dobara connect (reconnect) karna tha.

Jab ek group ke liye ye kaam sahi ho gaya, tab maine socha ki isi process ko har group ke 
liye `while` loop me repeat kar dete hain.

Yani meri thinking kuch is tarah thi:

➡️ Find one k-group
➡️ Make it an independent linked list
➡️ Reverse it using the normal reverse linked list algorithm
➡️ Reconnect it with the remaining list
➡️ Repeat the same process for every group

Is approach ke saath maine problem solve ki aur ye **LeetCode Accepted** bhi ho gaya. ✅

Sabse achchi baat ye lagi ki is problem ke liye mujhe koi naya reverse algorithm nahi banana pada.
Maine sirf wahi reverse logic use kiya jo mujhe pehle se aata tha, bas usse group-wise apply kiya.

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
