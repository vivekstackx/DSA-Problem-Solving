import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;


class TreeNode{
   TreeNode left;
   int data;
   TreeNode right;
     TreeNode(int data){
       this.left = null;
       this.data = data;
       this.right = null;
     }
}

class Tree{

   boolean getPath(TreeNode root , int burningTarget , Deque<TreeNode> stackPath){

        if(root == null) return false;

        stackPath.push(root);

        if(root.data == burningTarget) return true;

       boolean left = getPath(root.left , burningTarget , stackPath);
       if(left) return true;

       boolean right = getPath(root.right, burningTarget , stackPath);
       if(right) return true;

        stackPath.pop();

        return false;
   }

   int getHeight(TreeNode root){

       if(root == null) return -1;

       return 1 + Math.max(getHeight(root.left) , getHeight(root.right));
   }

   int burningTree(TreeNode root , int burningTarget){
    
    Deque<TreeNode> stackPath = new ArrayDeque<>();

     getPath(root , burningTarget , stackPath);
     
     Map<Integer, TreeNode> mapOfPath = new HashMap<>();

     int size = stackPath.size();

     for(int i = 0; i < size; i++){
       mapOfPath.put(i , stackPath.pop());
     }

    int timer = 0;

    for(Map.Entry<Integer, TreeNode> entry : mapOfPath.entrySet()) {

      int keyTimer = entry.getKey();
      TreeNode pathNode = entry.getValue();
      
     if(keyTimer == 0){
      
       int height = getHeight(pathNode);
       timer = height;
     }
     else{
       
         if(pathNode.left != null){

            if(!mapOfPath.containsValue(pathNode.left)){

               int leftHeight = getHeight(pathNode.left);

               timer = Math.max(timer , leftHeight + keyTimer + 1);
            }
         }

         if(pathNode.right != null){

            if(!mapOfPath.containsValue(pathNode.right)){

               int rightHeight = getHeight(pathNode.right);

               timer = Math.max(timer , rightHeight + keyTimer + 1);
            }
         }
     }
}
  
   if(root.left == null || root.right == null){
     return Math.max(timer , size - 1);
   }
   return timer;
      
   }
}

public class Main {
    public static void main(String[] args) {
      
       TreeNode root = null;
       root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.left.left = new TreeNode(4);
       root.left.left.left = new TreeNode(8);
       root.left.left.right = new TreeNode(9);
       root.left.left.right.right = new TreeNode(14);
       root.left.right = new TreeNode(5);

       root.right = new TreeNode(3);
       root.right.left = new TreeNode(6);
       root.right.left.left = new TreeNode(10);
       root.right.left.left.left = new TreeNode(15);
       root.right.left.left.left.left = new TreeNode(25);
       root.right.left.left.right = new TreeNode(16);
       root.right.left.right = new TreeNode(11);
       root.right.right = new TreeNode(7);
       root.right.right.left = new TreeNode(12);
       root.right.right.left.left = new TreeNode(17);
       root.right.right.left.right = new TreeNode(18);
       root.right.right.left.left.left = new TreeNode(21);
       root.right.right.left.left.right = new TreeNode(22);
       root.right.right.right = new TreeNode(13);
       root.right.right.right.right = new TreeNode(19);       



       int burningTarget = 12;

       int timer = new Tree().burningTree(root , burningTarget);

       System.out.println(timer + " seconds.");
    }
}
