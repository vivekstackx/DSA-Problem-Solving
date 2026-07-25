class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            // current level
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            
            while(size > 0){
                TreeNode curr = queue.poll();
                max = Math.max(max , curr.val);
                size--;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            ans.add(max);
            
        }
        return ans;
    }
}
