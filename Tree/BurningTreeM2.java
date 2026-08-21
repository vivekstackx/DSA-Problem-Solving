import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;


class Solution {

private boolean getPath(TreeNode root , int burningTarget , Deque<TreeNode> stackPath, Set<TreeNode> isFireSet){

            if(root == null) return false;

            stackPath.push(root);
            isFireSet.add(root);

            if(root.val == burningTarget) return true;

           boolean left = getPath(root.left , burningTarget , stackPath , isFireSet);
           if(left) return true;

           boolean right = getPath(root.right, burningTarget , stackPath , isFireSet);
           if(right) return true;

            isFireSet.remove(stackPath.pop());

            return false;
       }

      private int getHeight(TreeNode root){

           if(root == null) return -1;

           return 1 + Math.max(getHeight(root.left) , getHeight(root.right));
       }


     private int burningTree(TreeNode root , int burningTarget){
          
           Deque<TreeNode> stackPath = new ArrayDeque<>();
           Set<TreeNode> isFireSet = new HashSet<>();
           
           getPath(root , burningTarget, stackPath, isFireSet);
    
           int timer = 0;
           int burningNodeOfPathTime = 0;
           
           while(!stackPath.isEmpty()){
               
               TreeNode node = stackPath.pop();
               
               // burning target node
               if(burningNodeOfPathTime == 0){
                   timer = getHeight(node);
               }
               else{
                   
                    if(node.left == null || node.right == null){
                        timer = Math.max(timer , burningNodeOfPathTime);
                    }
                    else if(!isFireSet.contains(node.left)){
                       int leftHeight = getHeight(node.left);
                       timer = Math.max(timer , leftHeight + 1 + burningNodeOfPathTime);
                    }
                    else{
                        int rightHeight = getHeight(node.right);
                       timer = Math.max(timer , rightHeight + 1 + burningNodeOfPathTime);
                    }
               }
               
               burningNodeOfPathTime++;
           }
 
          return timer;
       }
    
    

    public int amountOfTime(TreeNode root, int start) {
        
        int timer = burningTree(root, start);

        return timer;

    }
}
