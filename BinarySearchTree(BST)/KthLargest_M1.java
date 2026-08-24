
class Solution {
    private int kth , largest;
    
    private void inorderTraverse(Node root){
        
        if(root == null) return;
        
        inorderTraverse(root.right);
        
        if(kth == 0) return;
        kth--;
        
        if(kth == 0){
            largest = root.data;
            return;
        }
        
        inorderTraverse(root.left);
        
    }
    
    public int kthLargest(Node root, int k) {
        // code here
        kth = k;
        
        inorderTraverse(root);
        
        return largest;
    }
}
