/*
  time : o(n)
*/
/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Box {
  
    boolean isBST;
    int min , max , size;
    
    Box(boolean isBST , int min , int max , int size){
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.size = size;
    }
}


class Solution {
    
    
    private Box postorder(Node root){
         
         if(root == null){
             return new Box(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
         }
         
         Box left = postorder(root.left);
         Box right = postorder(root.right);
         
         if(left.isBST && right.isBST && left.max < root.data && right.min > root.data){
             // current root is bst 
             int min = left.min == Integer.MAX_VALUE ? root.data : left.min;
             int max = right.max == Integer.MIN_VALUE ? root.data : right.max;
             int size = left.size + right.size + 1;
             
             return new Box(true, min , max , size);
         }
         else{
             // current root is not bst 
             if(left.size > right.size){
                 return new Box(false , left.min , left.max , left.size);
             }
             else{
                 return new Box(false, right.min , right.max , right.size);
             }
         }
         
    }
    
    public int largestBst(Node root) {
        // code here
       Box box = postorder(root);
       return box.size;
    }
}
