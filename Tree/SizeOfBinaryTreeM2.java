class Solution {
   
   private int countNodesUsingLevelOrder(TreeNode root){

        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int countNode = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size > 0){

                TreeNode curr = queue.poll();
                countNode++;
                size--;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return countNode;
    }

    public int countNodes(TreeNode root) {
       
       return countNodesUsingLevelOrder(root);
    }
}
