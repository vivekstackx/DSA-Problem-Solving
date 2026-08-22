
class Solution {
   
    private TreeNode startingFiredNode;

    private void preOrder(TreeNode root ,  Map<TreeNode , TreeNode> parentAssignMap, int target){
        
           if(root == null) return;
           
           if(root.val == target){
             startingFiredNode = root;
           }

           if(root.left != null){
             parentAssignMap.put(root.left , root);
           }
           if(root.right != null){
             parentAssignMap.put(root.right , root);
           }

           preOrder(root.left , parentAssignMap, target);
           preOrder(root.right , parentAssignMap , target);
    }

  
     
     private int burningTree(TreeNode root , int fireTarget){
      
          Map<TreeNode , TreeNode> isParentMap = new HashMap<>();

          // assign parent for each node and get starting fire node
            preOrder(root, isParentMap , fireTarget);

         Set<TreeNode> isFire = new HashSet<>();
         
         // level order taraversal 
         Queue<TreeNode> queue = new ArrayDeque<>();

         queue.offer(startingFiredNode);
         isFire.add(startingFiredNode);

         int level = 0;

         while(!queue.isEmpty()){
            int size = queue.size();

            while(size > 0){
                TreeNode currNode = queue.poll();
                size--;
              
              if(currNode.left != null && !isFire.contains(currNode.left)){
                queue.offer(currNode.left);
                isFire.add(currNode.left);
              }
              
              if(currNode.right != null && !isFire.contains(currNode.right)){
                queue.offer(currNode.right);
                isFire.add(currNode.right);
              }
              
              TreeNode parentNode = isParentMap.get(currNode);

              if(parentNode != null && !isFire.contains(parentNode)){
                queue.offer(parentNode);
                isFire.add(parentNode);
              }

                
            }

            level++;
         }

         return level - 1;
       }
    
  
    public int amountOfTime(TreeNode root, int start) {
        
        startingFiredNode = null;

        int timer = burningTree(root, start);

        return timer;

    }
}
