class Solution {

     private int getMaxLevel(TreeNode root){
        
        if(root == null){
            return 0;
        }
        int lh = getMaxLevel(root.left);
        int rh = getMaxLevel(root.right);
        
        return Math.max(lh , rh) + 1;
    }

     private void getRightView(TreeNode root , int level , boolean[] visited , List<Integer> list){
        
           if(root == null){
               return;
           }
           if(!visited[level - 1]){
               visited[level - 1] = true;
               list.add(root.val);
           }
           
           getRightView(root.right , level + 1 , visited , list);
           getRightView(root.left , level + 1 , visited, list);
    }
    

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        int height = getMaxLevel(root);
        
        boolean[] visited = new boolean[height];
        
        getRightView(root , 1 , visited , ans);
        return ans;
    }
}
