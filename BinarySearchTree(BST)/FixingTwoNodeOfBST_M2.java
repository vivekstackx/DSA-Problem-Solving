/*
  time : o(n)
  space : o(n) or o(h)
*/

/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */
class Solution {
    
    private Node prev , first , second;
    
    private boolean inorder(Node root){
       
        if(root == null) return true;
        
        boolean left = inorder(root.left);
        if(!left) return false;
        
         if(prev != null){
             
             if(root.data < prev.data){
                 
                if(first == null && second == null){
                    first = prev;
                    second = root;
                }
                else{
                    second = root;
                    return false;
                }
             }
         }
         
         prev = root;
        
      boolean right = inorder(root.right);
      if(!right) return false;
      
      return true;
    }
    
    
    
    public Node correctBST(Node root) {
        
        prev = first = second = null;
        
        inorder(root);

        // swap problems occuring nodes
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        
        return root;
        
        
    }
};
