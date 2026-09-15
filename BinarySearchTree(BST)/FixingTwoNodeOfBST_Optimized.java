/*
  time : o(n)
  space : o(1)
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
    
    private Node prev , first , second , curr;
    
   
   private void helper(){
       
         if(prev != null){
                    
             if(curr.data < prev.data){
                        
                if(first == null && second == null){
                     first = prev;
                     second = curr;
                }
                 else second = curr;
             }
         }
         
      prev = curr;
      
    }
    
    public Node morrisInorder(Node root) {
        
        prev = first = second = null;
        curr = root;
        
        while(curr != null){
            
            if(curr.left == null){
                
                helper();
               
                curr = curr.right;
            }
            else{
                Node temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }
                else{
                    
                    temp.right = null;
                    
                    helper();
                    
                   curr = curr.right;
                
                }
                
            }
        }
        
        //swap
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        
        return root;
    }
    

    
     public Node correctBST(Node root){
        
        return morrisInorder(root);
        
    }
    
};
