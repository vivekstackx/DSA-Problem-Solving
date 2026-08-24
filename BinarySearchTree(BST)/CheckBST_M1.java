
class Solution {

    private void inorderTraverse(TreeNode root , List<Integer> inorderList){
      
        if(root == null) return;

        inorderTraverse(root.left , inorderList);
        inorderList.add(root.val);
        inorderTraverse(root.right , inorderList);
    }

    public boolean isValidBST(TreeNode root) {
        
        List<Integer> inorderList = new ArrayList<>();

        inorderTraverse(root , inorderList);

        for(int i = 1; i < inorderList.size(); i++){
            if(inorderList.get(i) <= inorderList.get(i-1)) return false;
        }

        return true;
    }
}
