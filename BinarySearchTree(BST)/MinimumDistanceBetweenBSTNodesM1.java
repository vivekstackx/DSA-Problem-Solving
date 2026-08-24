
class Solution {

     private void inorderTraverse(TreeNode root , List<Integer> inorderList){
      
        if(root == null) return;
        
        inorderTraverse(root.left , inorderList);
        
        inorderList.add(root.val);
        
        inorderTraverse(root.right , inorderList);
    }
    

    public int minDiffInBST(TreeNode root) {
        
        List<Integer> inorderList = new ArrayList<>();
        
        inorderTraverse(root , inorderList);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 1; i < inorderList.size(); i++){
            
            minDiff = Math.min(minDiff , inorderList.get(i) - inorderList.get(i - 1));
        }
        
        return minDiff;
    }
}
