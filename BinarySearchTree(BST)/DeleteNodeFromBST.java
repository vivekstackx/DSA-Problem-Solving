
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // node not exists
        if(root == null) return null; 
        
        // if node found
        if(root.val == key){
            
            // leaf node 
            if(root.left == null && root.right == null){
                return null;
            }
            // only one child persent 
            if(root.left == null || root.right == null){
                
               if(root.left != null) return root.left;
               else return root.right;
            }
            // both child persent 
            TreeNode child = null;
            TreeNode parent = null;
            
            child = root.left;
            
            while(child.right != null){
                parent = child;
                child = child.right;
            }
            
            if(parent == null){
                child.right = root.right;
                return child;
            }
            else{
                parent.right = child.left;
                child.left = root.left;
                child.right = root.right;
                return child;
            }
            
        }
        
        if(key < root.val){
            root.left = deleteNode(root.left , key);
            return root;
        }
        else{
            root.right = deleteNode(root.right , key);
            return root;
        }
    }
}
