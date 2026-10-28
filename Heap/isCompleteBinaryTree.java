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

    private int maxIndex; 
    
    private void preorder(TreeNode root , int currIndex){
     
         if(root  == null) return;
         
         maxIndex = Math.max(maxIndex , currIndex);
         
         preorder(root.left , 2 * currIndex + 1);
         preorder(root.right , 2 * currIndex + 2); 
    }
    
    private void preorderHelper(TreeNode root , boolean[] visited , int currIndex){
       
         if(root == null) return;
         
         visited[currIndex] = true;
         
         preorderHelper(root.left , visited , 2 * currIndex + 1); 
         preorderHelper(root.right , visited , 2 * currIndex + 2);
    }


    public boolean isCompleteTree(TreeNode root) {
          
          maxIndex = 0; 
          
          preorder(root , 0); 
        
        boolean[] visited = new boolean[maxIndex + 1]; 
        
        preorderHelper(root , visited , 0);
        
        for(int i = 0; i < visited.length; i++){
            
            if(!visited[i]) return false; 
        }
        
        return true; 
    }
}
