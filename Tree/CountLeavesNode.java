class Solution {
    int countLeaves(Node root) {
      
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftLeavesCount = countLeaves(root.left);
        int rightLeavesCount = countLeaves(root.right);
        
        return leftLeavesCount + rightLeavesCount;
    
    }
}
