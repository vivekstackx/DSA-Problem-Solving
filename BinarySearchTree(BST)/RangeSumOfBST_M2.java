
class Solution {
   private int sum;
   
   private void helper(TreeNode root , int low , int high){
       
         if(root == null) return;

         if(low < root.val && high < root.val){
            helper(root.left , low , high);
         }
         else if(low > root.val && high > root.val){
            helper(root.right , low , high);
         }
         else{
              // split point where the direction of low and high are different 
               if(low <= root.val && root.val <= high){
                  sum = sum + root.val;
               }

               helper(root.left , low , high);
               helper(root.right , low , high); 
         }
   }

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0; 

        helper(root , low , high);

        return sum;

    }
}
