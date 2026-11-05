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
       
        if(lists.length == 0) return null; 

       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
       
       for(int i = 0; i < lists.length; i++){
          if(lists[i] != null){
             minHeap.offer(lists[i]);
          }
       }
      
       ListNode dummyNode = new ListNode(0);
       ListNode tail = dummyNode; 

       while(!minHeap.isEmpty()){
          
          ListNode node = minHeap.poll();
          tail.next = node; 
          tail = node;

          if(node.next != null){
             minHeap.offer(node.next);
          }

       }
       
       return dummyNode.next;
    }
}
