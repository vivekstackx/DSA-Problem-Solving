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

class Box{
   boolean isBST;
   int min , max , sum;
    
      Box(boolean isBST , int min , int max , int sum){
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;
      }
}

class Solution {
   private int maxSum;

  private Box postorder(TreeNode root){
      
      if(root == null){
        return new Box(true , Integer.MAX_VALUE , Integer.MIN_VALUE, 0);
      }

      Box left = postorder(root.left);
      Box right = postorder(root.right);

      if(left.isBST && right.isBST && left.max < root.val && right.min > root.val){
        
         int min = left.min == Integer.MAX_VALUE ? root.val : left.min;
         int max = right.max == Integer.MIN_VALUE ? root.val : right.max;
         int sum = left.sum + right.sum + root.val;
         maxSum = Math.max(maxSum , sum);

         return new Box(true , min , max , sum);
      }
      else{
          if  (left.sum > right.sum){
             return new Box(false, left.min , left.max , left.sum);
          }
          else{
            return new Box(false, right.min, right.max , right.sum);
          }
      }
  }

    public int maxSumBST(TreeNode root) {

        Box box = postorder(root);
        return maxSum < 0 ? 0 : maxSum;
    }
}
