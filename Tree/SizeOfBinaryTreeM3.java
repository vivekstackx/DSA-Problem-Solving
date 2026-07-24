class Solution {
    private int count;

     Solution(){
        count = 0;
     }

   private void preOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        count++;
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public int countNodes(TreeNode root) {
       
        preOrderTraverse(root);

        return count;
    }
}
