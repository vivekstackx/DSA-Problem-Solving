
class Solution {
 private int sum;
    // get the split point where direction of two node moves to diffrent direction
    private TreeNode getLowestCommonAncestor(TreeNode root , int low , int high){
            
            if(root == null) return null;

            if(low < root.val && high < root.val){
                return getLowestCommonAncestor(root.left , low , high);
            }
            else if(low > root.val && high > root.val){
                return getLowestCommonAncestor(root.right , low , high);
            }
            else return root; // lca 
    }

    private void preorderTraverse(TreeNode root , int low , int high){

           if(root == null) return;

           if(low <= root.val && root.val <= high){
              sum = sum + root.val;
           }

           preorderTraverse(root.left , low , high);
           preorderTraverse(root.right , low , high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        
        TreeNode lca = getLowestCommonAncestor(root , low , high);
        
        preorderTraverse(lca , low , high);

        return sum;

    }
}
