class Solution {
  
  private void getRightView(TreeNode root, int level ,List<Integer> list){
      if(root == null){
          return;
      }
      
      if(level > list.size()){
          list.add(root.val);
      }

      getRightView(root.right, level + 1 , list);
      getRightView(root.left , level + 1 , list);
      
  }
   public List<Integer> rightSideView(TreeNode root) {
       
       List<Integer> ans = new ArrayList<>();
       
       getRightView(root , 1, ans);
       
       return ans;
    }
}
