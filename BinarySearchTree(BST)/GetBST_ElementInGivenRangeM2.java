
class Solution {
    
    private void helper(Node root , ArrayList<Integer> ans ,  int low , int high){
     
          if(root == null) return;
          
          if(low < root.data && high < root.data){
              helper(root.left , ans , low , high);
          }
          else if(low > root.data && high > root.data){
              helper(root.right , ans , low , high);
          }
          else {
               // split point 
               helper(root.left , ans , low , high);
               
               if(low <= root.data && root.data <= high){
                   ans.add(root.data);
               }
               
               helper(root.right , ans , low , high);
          }
    }
    
    public ArrayList<Integer> nodesInRange(Node root, int low, int high) {
        // code here
         ArrayList<Integer> ans = new ArrayList<>();
         
         helper(root , ans , low , high); 
              
         return ans;
         
    }
}
