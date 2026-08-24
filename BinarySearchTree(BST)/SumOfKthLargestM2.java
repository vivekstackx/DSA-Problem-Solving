
class Solution {
    
   private int sum , kth;
   
  private void inorderTraverse(Node root){
      
      if(root == null) return;
      
      inorderTraverse(root.right);
      
      if(kth == 0) return;
      
      sum = sum + root.data;
      kth--;
      
      inorderTraverse(root.left);
     
  }
  
    int sum(Node root, int k) {
     
      kth = k;
      sum = 0;
      
      inorderTraverse(root);
      
      return sum;
       
       
        
    }
}
