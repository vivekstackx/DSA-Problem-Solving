
class Solution {
    
    private void inorderTraverse(Node root , List<Integer> inorderList){
        
         if(root == null) return;
         
         inorderTraverse(root.left , inorderList);
         
         inorderList.add(root.data);
         
         inorderTraverse(root.right , inorderList);
    }
    
    int sum(Node root, int k) {
        // Code here
        
        List<Integer> inorderList = new ArrayList<>();
        
        inorderTraverse(root, inorderList);
        
        int sum = 0;
        
        for(int i = 0; i < inorderList.size(); i++){
            
            if(k == 0) break;
            
            sum = sum + inorderList.get(i);
            k--;
        }
        
        return sum;
        
    }
}
