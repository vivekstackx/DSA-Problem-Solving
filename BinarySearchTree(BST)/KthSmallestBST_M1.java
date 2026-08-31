
/*
 time complexity : O(N2)
*/

class Solution {

  private void inorderTraverse(TreeNode root , List<Integer> inorderList){
        
         if(root == null) return;
         
         inorderTraverse(root.left , inorderList);
         
         inorderList.add(root.val);
         
         inorderTraverse(root.right , inorderList);
    }


    public int kthSmallest(TreeNode root, int k) {

        List<Integer> inorderList = new ArrayList<>();
        
        inorderTraverse(root, inorderList);

        int kth = Integer.MAX_VALUE;

        for(int i = 0; i < inorderList.size(); i++){
            
            if(k == 1){
              kth = inorderList.get(i);
              break;
            }

            k--;
        }
        
        return kth;

    }
}
