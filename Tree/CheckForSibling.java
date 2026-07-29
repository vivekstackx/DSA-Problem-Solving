class Solution {
    // check for sibling 
    private boolean isSibling(TreeNode root , int x , int y){
         if(root == null){
            return false;
         }
         if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x){
                return true;
            }
         }
         boolean left = isSibling(root.left , x , y);
         if(left) return true;
         boolean right = isSibling(root.right , x , y);
         if(right) return true;

         return false;
    }

}
