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
class Solution {
    
    private int countTotalNode(TreeNode root){

        if(root == null) return 0;

        return countTotalNode(root.left) + countTotalNode(root.right) + 1;
    }

    private boolean preorderHelper(TreeNode root , int totalNode , int index){

        if(root == null) return true;

        if(index >= totalNode) return false;

        boolean left = preorderHelper(root.left , totalNode , 2 * index + 1);
        if(!left) return false;

        boolean right = preorderHelper(root.right , totalNode , 2 * index + 2);
        if(!right) return false;

        return true;

    }
    
    public boolean isCompleteTree(TreeNode root) {
        
        int totalNode = countTotalNode(root);

       return preorderHelper(root , totalNode , 0);
        
    }
}
