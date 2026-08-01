
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
         List<Integer> ans = new ArrayList<>();
         
         if(root == null){
            return ans;
         }

         Queue<TreeNode> queue = new ArrayDeque<>();
         queue.offer(root);

         while(!queue.isEmpty()){
            // current level processing 
            int size = queue.size();
            // store the last node of each level
            while(size > 0){
                TreeNode curr = queue.poll();
                 
                 if(size == 1){
                    ans.add(curr.val);
                 }
                size--;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }

            }
         }

         return ans;
    }
}
