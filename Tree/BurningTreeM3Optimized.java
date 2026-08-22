
class Solution {
   
   private int timer;
   private TreeNode burningTargetNode;

     /*
      positive value means height
      negative value means fire

     */
     private int burningTree(TreeNode root , int burningTarget){
          
            if(root == null) return 0;

            if(root.val == burningTarget){
                burningTargetNode = root; // fire start
                return -1; // fire
            }

            int left = burningTree(root.left, burningTarget);
            int right = burningTree(root.right, burningTarget);

            if(left < 0){
                timer = Math.max(timer , Math.abs(left) + right);
                return left - 1; // fire
            }
            if(right < 0){
                timer = Math.max(timer , Math.abs(right) + left);
                return right - 1; // fire
            }

            return Math.max(left , right) + 1; // height




       }
    
    private int getHeight(TreeNode root){

      if(root == null) return 0;

      return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }

    public int amountOfTime(TreeNode root, int start) {

          timer = 0;
          burningTargetNode = null;

         burningTree(root, start);

         int height = getHeight(burningTargetNode);

         timer = Math.max(timer , height - 1);

        return timer;

    }
}
