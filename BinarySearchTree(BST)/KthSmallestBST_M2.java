
class Solution {
    private int kth , smallest;

    private void inorderTraverse(TreeNode root){
       
        if(root == null) return;

        inorderTraverse(root.left);

        if(kth == 0) return;
        kth--;

        if(kth == 0){
            smallest = root.val;
            return;
        }

        inorderTraverse(root.right);
    }


    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        smallest = Integer.MIN_VALUE;
        
        inorderTraverse(root);
        
        return smallest;
    }
}
