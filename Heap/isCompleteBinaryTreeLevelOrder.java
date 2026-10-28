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

    public boolean isCompleteTree(TreeNode root) {
          
        if(root == null) return true;

       Queue<TreeNode> q = new LinkedList<>();

       q.offer(root); 
       
       boolean isCBT = true;
       boolean isActive = false; 

       outer: while(!q.isEmpty()){
          
          int size = q.size();    
          // current level 

          while(size > 0){
             
               TreeNode current = q.poll();  
                size--; 
                
                if(isActive && current != null){
                   isCBT = false;
                   break outer; 
                }
               
               if(current != null){

                    q.offer(current.left); 
                    q.offer(current.right);
               }
               else{
                   isActive = true; 
                     
               }
            
          }
       }

       return isCBT;
    }
}
