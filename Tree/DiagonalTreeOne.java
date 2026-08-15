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

   private int leftMostPosition;

   private void getPosition(TreeNode root , int position){
     
       if(root == null) return;

       leftMostPosition = Math.min(leftMostPosition , position);

       getPosition(root.left , position - 1);
       getPosition(root.right, position);
   }

    void helper(TreeNode root , int leftMove , List<List<Integer>> ans){
       
         if(root == null) return;
       
        ans.get(leftMove).add(root.data);

        helper(root.left , leftMove + 1 , ans);
        helper(root.right , leftMove , ans);

    }


   List<List<Integer>> diagonalTree(TreeNode root){
       
       List<List<Integer>> ans = new ArrayList<>();

       if(root == null) return ans;

       getPosition(root , 0);

       int totalDiagonalLine = Math.abs(leftMostPosition - 1);

       for(int i = 1; i <= totalDiagonalLine; i++){
         ans.add(new ArrayList<>());
       }

      int leftMove = 0;

      helper(root , leftMove , ans);
      
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
