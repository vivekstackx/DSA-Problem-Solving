class Solution {
    private int getHeight(TreeNode root){
         
         if(root == null){
            return 0;
         }

         int leftHeight = getHeight(root.left);
         if(leftHeight == -1) return -1;

         int rightHeight = getHeight(root.right);
         if(rightHeight == -1) return -1;

         int diff = leftHeight - rightHeight;

         if(diff < -1 || diff > 1){
            return -1; // not balanaced
         }

         return Math.max(leftHeight , rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        
         int height = getHeight(root);

         return height == -1 ? false : true;
    }
}
