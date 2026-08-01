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
            
            ans.add(queue.peek().val);

            while(size > 0){
                TreeNode curr = queue.poll();
                size--;

                if(curr.right != null){
                    queue.offer(curr.right);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }

            }
         }

         return ans;
    }
}
