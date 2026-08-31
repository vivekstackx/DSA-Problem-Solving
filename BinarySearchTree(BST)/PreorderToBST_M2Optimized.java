/*
 time complextiy : O(N)

*/

class Solution {
   private int index;

    private TreeNode helper(int[] preorder , int lowerBound , int upperBound){
          
           if(index == preorder.length) return null; // invalid index 

           // range checking 
           if(!(lowerBound < preorder[index] && preorder[index] < upperBound)) return null;
           
           TreeNode newNode = new TreeNode(preorder[index]);
           index++;

           newNode.left = helper(preorder , lowerBound , newNode.val);
           newNode.right = helper(preorder , newNode.val , upperBound);

           return newNode;
           
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        
         int lowerBound = Integer.MIN_VALUE;
         int upperBound = Integer.MAX_VALUE;
         index = 0;

         return helper(preorder , lowerBound , upperBound);
    }
}
