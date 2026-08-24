
class Solution {

   private int previousData;
   private boolean hasPrevious;

    private boolean inorderTraverse(TreeNode root){
      
        if(root == null) return true;

        boolean left = inorderTraverse(root.left);
        if(left == false) return false;

        if(hasPrevious && root.val <= previousData) return false; // not BST
        
        previousData = root.val;
        hasPrevious = true;

       boolean right = inorderTraverse(root.right);
       if(right == false) return false;

       return true;
    }

    public boolean isValidBST(TreeNode root) {
      
       hasPrevious = false;

       return inorderTraverse(root);  
      
    }
}
