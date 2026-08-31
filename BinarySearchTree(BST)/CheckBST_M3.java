
class Solution { 

   // function to check the bst from preorder
   private boolean helper(TreeNode root , long lowerBound , long upperBound){
     
      if(root == null) return true;

      if(!(lowerBound < root.val && root.val < upperBound)) return false;

      boolean left = helper(root.left , lowerBound , root.val);
      if(!left) return false;

      boolean right = helper(root.right , root.val , upperBound);
      if(!right) return false;

     return  true;
   }
  
     public boolean isValidBST(TreeNode root) {
   
       long lowerBound = Long.MIN_VALUE;
       long upperBound = Long.MAX_VALUE;
      
       return helper(root , lowerBound , upperBound);
    }
}
