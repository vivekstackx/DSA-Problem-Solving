
class Solution {
    
    private boolean helper(Node root , int lowerbound , int upperbound){
    
            if(root == null) return false;
            
            if(root.left == null && root.right == null){
                
                // check for left side 
                int leftRange = root.data - lowerbound;
                int rightRange = upperbound - root.data; 
                // dead end
                if(leftRange == 1 && rightRange == 1){
                    return true;
                }
                else return false;
            }
            
            boolean left = helper(root.left , lowerbound , root.data);
            if(left) return true; 
            
            boolean right = helper(root.right , root.data , upperbound);
            if(right) return true; 
            
            return false;
    }
    
    public boolean isDeadEnd(Node root) {
        // Code here.
        int lowerbound = 0; 
        int upperbound = Integer.MAX_VALUE;
        
       return helper(root , lowerbound , upperbound);
    }
}
