
class Solution {
    private int pathSum;

    private int helper(Node root){ 

        if(root == null) return 0;

        if(root.left == null && root.right == null) return root.data ;

        int left = helper(root.left);
        int right = helper(root.right);

        // left and right are exits
        if(root.left != null && root.right != null){
           pathSum = Math.max(pathSum , left + right + root.data);
           return Math.max(left , right) + root.data;
        }

        // only left exits
        if(root.left != null){
            return left + root.data;
        }

        // only right exits
        if(root.right != null){
            return right + root.data;
        }

        return 0;
    }
    
    
    public int maxPathSum(Node root) {
        // code here
        pathSum = Integer.MIN_VALUE;

        int sum = helper(root);

        if(root.left != null && root.right != null){
            return pathSum;
        }

        return Math.max(pathSum , sum);
    }
}
