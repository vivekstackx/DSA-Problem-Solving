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
    public ListNode mergeKLists(ListNode[] lists) {
      
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
       
        // copy each node in min heap 
        for(int i = 0; i < lists.length; i++){

            ListNode currList = lists[i]; 
            ListNode curr = currList; 
            ListNode previous = null; 

            while(curr != null){
            
                minHeap.offer(curr);
                previous = curr; 
                curr = curr.next;
                previous.next = null; // connection break

            }
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode; 

        while(!minHeap.isEmpty()){
           
           ListNode node = minHeap.poll();
           tail.next = node;
           tail = node;
        }

        return dummyNode.next;

    }
}
