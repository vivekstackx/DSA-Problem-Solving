 /* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Solution {
    private int currSubTreeSize, size;
    
    private boolean isBST(Node root , int lowerbound , int upperbound){
        
         if(root == null) return true;
         
         currSubTreeSize++;
         // not lies in this range that means it is not bst 
         if(!(lowerbound < root.data && root.data < upperbound)) return false;
         
         boolean left = isBST(root.left , lowerbound , root.data);
         if(!left) return false;
         
         boolean right = isBST(root.right , root.data , upperbound);
         if(!right) return false;
           
         return true; 
         
    }
    
    private void preorder(Node root){
        
         if(root == null) return;
         
         currSubTreeSize = 0;
         
         if(isBST(root , Integer.MIN_VALUE , Integer.MAX_VALUE)){
            size = Math.max(size , currSubTreeSize);
            return;
         }
         preorder(root.left);
         preorder(root.right);
    }
    
    
    public int largestBst(Node root) {
        // code here
        preorder(root);
        
        return size; 
    }
}
