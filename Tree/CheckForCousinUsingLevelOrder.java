class Solution {
   
   //use level order traversal technique
    boolean isCousingsUsingLevelOrder(TreeNode root , int x , int y){
        
        if(root == null){
            return false;
        }

        boolean isSiblings = false;
        int levelX = -1;
        int levelY = -1;

        int level = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            // current level processing 
            int size = queue.size();
            
            while(size > 0){
              TreeNode temp = queue.poll();
              size--;
              // check level for x 
              if(temp.val == x){
                levelX = level;
              }
              // check level for y
              if(temp.val == y){
                levelY = level;
              }
              if(levelX != -1 && levelY != -1){
                return levelX == levelY && !isSiblings;
              }
             // checking for siblings
             if(temp.left != null && temp.right != null){
                if(temp.left.val == x && temp.right.val == y || temp.left.val == y && temp.right.val == x){
                    isSiblings = true;
                }
             }

             if(temp.left != null){
                queue.offer(temp.left);
             }
             if(temp.right != null){
                queue.offer(temp.right);
             }
          }
          level++;
        }

       return false;
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        
         return isCousingsUsingLevelOrder(root, x, y);
    }
}
