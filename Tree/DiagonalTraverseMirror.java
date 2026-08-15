import java.util.List;
import java.util.ArrayList;

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


class Tree {

   private int rightMostPosition;

   private void getPosition(TreeNode root , int position){
     
       if(root == null) return;

       rightMostPosition = Math.max(rightMostPosition , position);

       getPosition(root.left , position);
       getPosition(root.right, position + 1);
   }

    void helper(TreeNode root , int rightMove , List<List<Integer>> ans){
       
         if(root == null) return;
       
        ans.get(rightMove).add(root.data);

        helper(root.right , rightMove + 1 , ans);
        helper(root.left , rightMove , ans);

    }


   List<List<Integer>> diagonalTree(TreeNode root){
       
       List<List<Integer>> ans = new ArrayList<>();

       if(root == null) return ans;

       rightMostPosition = 0;
       
       getPosition(root , 0);
       
       int totalDiagonalLine = rightMostPosition + 1;

       for(int i = 1; i <= totalDiagonalLine; i++){
         ans.add(new ArrayList<>());
       }

      int rightMove = 0;

      helper(root , rightMove , ans);
      
      return ans;
   }


   void display(List<List<Integer>> list){
      
        for(List<Integer> currList : list){
          System.out.println(currList);
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
        root.left.left.right = new TreeNode(8);
        root.left.left.right.left = new TreeNode(11);
        root.left.left.right.left.left = new TreeNode(21);
        root.left.left.right.left.left.left = new TreeNode(30);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        Tree tree = new Tree();

        List<List<Integer>> ans = tree.diagonalTree(root);
       
        tree.display(ans);

    }
}
