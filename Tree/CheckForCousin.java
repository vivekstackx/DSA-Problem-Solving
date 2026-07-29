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

    // check level for node 
  private int getLevelOfNode(TreeNode root , int x , int level){

        if(root == null){
            return -1;
        }
        if(root.val == x){
            return level;
        }
        int left = getLevelOfNode(root.left , x , level + 1);
        if(left != -1) return left;
        int right = getLevelOfNode(root.right , x , level + 1);
        if(right != -1) return right;

        return -1;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null){
            return false;
        }

        // level should be same (generation same)
        int levelOfX = getLevelOfNode(root , x , 1);
        int levelOfY = getLevelOfNode(root , y , 1);

        return levelOfX == levelOfY && !isSibling(root, x , y);
    }
}
