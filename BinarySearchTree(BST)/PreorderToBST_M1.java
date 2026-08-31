
/*
 time complexity : O(N2)
 */

class Solution {

 // function to get the position for current node 
    private int getPosition(int[] preorder , int start , int end){
      
         for(int i = start + 1; i <= end; i++){

             if(preorder[i] > preorder[start]) return i;
         }

         return -1; // right subtree not exits
    }

    private TreeNode helper(int[] preorder , int start , int end){
      
        if(start > end) return null; 

        TreeNode newNode = new TreeNode(preorder[start]);

        int position = getPosition(preorder, start , end);
      
        /*
           if position is -1 that means right subtree are not eixts but left subtree 
           can be exits
         */
         if(position == -1){
            
            newNode.left = helper(preorder , start + 1 , end);
            return newNode;
         }
         else{
            
            newNode.left = helper(preorder , start + 1 , position - 1);
            newNode.right = helper(preorder , position , end);
         }
      
         return newNode;
    }


    public TreeNode bstFromPreorder(int[] preorder) {
         
         int start = 0; 
         int end = preorder.length - 1;

         return helper(preorder , start , end);

    }
}
