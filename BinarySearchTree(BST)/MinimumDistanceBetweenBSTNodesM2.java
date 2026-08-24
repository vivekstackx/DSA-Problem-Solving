/*
 Time complexity : O(N)
 space Complexity : O(1)
*/

class Solution {
    private int previousData;
    private int minDiff;
    private boolean hasPrevious;
    
    
    private void inorderTraverse(TreeNode root){
      
        if(root == null) return;
        
        inorderTraverse(root.left);
        
         if(hasPrevious){
             minDiff = Math.min(minDiff , root.val - previousData);
         }
         previousData = root.val;
         hasPrevious = true;
         
        inorderTraverse(root.right);
    }
    

    public int minDiffInBST(TreeNode root) {
        
       hasPrevious = false;
        
       minDiff = Integer.MAX_VALUE;
       
       inorderTraverse(root);
       
       return minDiff;
    }
}
