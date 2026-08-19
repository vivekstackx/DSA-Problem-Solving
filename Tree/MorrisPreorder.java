/*
  Time complexity : Worst case O(n)
  Space complexity : O(1)
*/

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

class Tree{

  List<Integer> morrisPreorder(TreeNode root){
     
     List<Integer> ans = new ArrayList<>();

       while(root != null){
          
           if(root.left == null){
             ans.add(root.data);
             root = root.right;
           }
           else{

             TreeNode curr = root.left;
              while(curr.right != null && curr.right != root){
                curr = curr.right; 
              }
              if(curr.right == null){
                 ans.add(root.data);
                 curr.right = root;
                 root = root.left;
              }
              else{
                 curr.right = null;
                 root = root.right;
              }
           }
       }

       return ans;
  }


}

public class Main {
    public static void main(String[] args) {
  
     TreeNode root = null;

     root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.left.left = new TreeNode(4);
     root.left.left.left = new TreeNode(6);
     root.left.left.right = new TreeNode(8);
     root.left.right = new TreeNode(5);
     root.left.right.right = new TreeNode(7);
     root.right = new TreeNode(3); 


    Tree tree = new Tree();

    List<Integer> ans = tree.morrisPreorder(root);

    System.out.println(ans);


    }
}
