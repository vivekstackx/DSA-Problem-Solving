
class Solution {
    
    private TreeNode helper(int[] nums, int start , int end){
         
          if(start > end) return null;

          int mid = start + (end - start) / 2;

          TreeNode root = new TreeNode(nums[mid]);

          root.left = helper(nums , start, mid - 1);
          root.right = helper(nums , mid + 1 , end);

          return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
         
         int start = 0;
         int end = nums.length - 1;

         return helper(nums , start, end);
    }
}
