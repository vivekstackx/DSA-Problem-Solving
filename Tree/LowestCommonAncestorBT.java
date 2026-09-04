
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
           if(root == null) return null;

           if(p.val == root.val || q.val == root.val) return root;

           TreeNode left = lowestCommonAncestor(root.left , p , q);
           TreeNode right = lowestCommonAncestor(root.right , p , q);

           // both are not present
           if(left == null && right == null) return null;

           // only one present 
           if(left == null || right == null){
              
               if(left != null) return left;
               else return right;
           }

           // both are present
            return root;
    }
}
