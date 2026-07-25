class Solution {
    int countNonLeafNodes(Node root) {
        
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return 0;
        }
        
        int leftLeafCount = countNonLeafNodes(root.left);
        int rightLeafCount = countNonLeafNodes(root.right);
        
        return leftLeafCount + rightLeafCount + 1;
    }
}
