
class Solution {
    
    private Node getLowestCommonAncestor(Node root , int low , int high){
       
         if(root == null) return null;
         
         if(low < root.data && high < root.data){
             return getLowestCommonAncestor(root.left , low , high);
         }
         else if(low > root.data && high > root.data){
             return getLowestCommonAncestor(root.right , low , high);
         }
         else return root; // lca 
    }
    
    private void inorderTraverse(Node root , ArrayList<Integer> ans , int low , int high){
     
         if(root == null) return;
         
         inorderTraverse(root.left , ans , low , high);
         
         if(low <= root.data && root.data <= high){ // range 
             ans.add(root.data);
         }
         
         inorderTraverse(root.right , ans , low , high);
    }
    
    public ArrayList<Integer> nodesInRange(Node root, int low, int high) {
      
        ArrayList<Integer> ans = new ArrayList<>();
        
        Node lca = getLowestCommonAncestor(root , low , high);
        
        inorderTraverse(lca , ans , low , high);
        
        return ans;
    }
}
