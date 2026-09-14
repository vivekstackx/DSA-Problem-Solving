/*
  time complexity : O(N)
  space complexity : O(N)
*/

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private TreeNode helper(int[] arr , int start , int end){
       
          if(start > end) return null;

          int mid = (start + end) / 2;

          TreeNode newNode = new TreeNode(arr[mid]);

          newNode.left = helper(arr , start , mid - 1);
          newNode.right = helper(arr , mid + 1 , end);

          return newNode;
    }


    public TreeNode sortedListToBST(ListNode head) {
        
        ListNode curr = head;
        int size = 0;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        int[] arr = new int[size];

        curr = head;
        int i = 0;

        while(curr != null){
           arr[i] = curr.val;
           i++;
           curr = curr.next;
        }

        int start = 0;
        int end = size - 1;

        return helper(arr , start , end);
    }
}
