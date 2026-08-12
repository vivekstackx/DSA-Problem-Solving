import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

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
  private int leftMostPosition, rightMostPosition;

  private void getPosition(TreeNode root, int position){
      
        if(root == null){
           return;
        }

        leftMostPosition = Math.min(leftMostPosition , position);
        rightMostPosition = Math.max(rightMostPosition , position);

       getPosition(root.left , position - 1);
       getPosition(root.right , position + 1);

  }

   List<List<Integer>> verticalLineTreverse(TreeNode root){
      
      List<List<Integer>> ans = new ArrayList<>();
      if(root == null){
        return ans;
      }

      getPosition(root , 0);

      int totalVerticalLine = rightMostPosition - leftMostPosition + 1;

      for(int i = 1; i <= totalVerticalLine; i++){
         ans.add(new ArrayList<>()); // empty list
      }

      Queue<TreeNode> queue = new ArrayDeque<>();
      Queue<Integer> queueIndex = new ArrayDeque<>();

     queue.offer(root);
     queueIndex.offer(Math.abs(leftMostPosition));

     while(!queue.isEmpty()){

        // current level proccessing...
          int size = queue.size();

          while(size > 0){
             
             TreeNode currNode = queue.poll();
             int nodeIndex = queueIndex.poll();
             size--;

             ans.get(nodeIndex).add(currNode.data);

             if(currNode.left != null){
                queue.offer(currNode.left);
                queueIndex.offer(nodeIndex - 1);
             }

             if(currNode.right != null){
              queue.offer(currNode.right);
              queueIndex.offer(nodeIndex + 1);
             }

          }
     }

    return ans;

   }


   void display(List<List<Integer>> list){

       for(List verticalLineList : list){
          System.out.println(verticalLineList);
       }
   }
}


public class Main {
    public static void main(String[] args) {
           
       TreeNode root = null; 

       root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.left.left = new TreeNode(4);
       root.left.left.left = new TreeNode(7);
       root.left.left.left.left = new TreeNode(11);
       root.left.left.right = new TreeNode(8);
       root.left.right = new TreeNode(5);
       root.right = new TreeNode(3);
       root.right.right = new TreeNode(6);
       root.right.right.left = new TreeNode(9);
       root.right.right.left.left = new TreeNode(12);
       root.right.right.right = new TreeNode(10);
       root.right.right.right.left = new TreeNode(13);
       root.right.right.right.left.right = new TreeNode(20);
       root.right.right.right.left.right.right = new TreeNode(25);
       root.right.right.right.right = new TreeNode(30);

      Tree tree = new Tree();

      List<List<Integer>> ans = tree.verticalLineTreverse(root);


      tree.display(ans);

    }
}
