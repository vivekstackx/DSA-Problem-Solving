/*
  Time complexity : O(n)
  Space complexity : O(1)
*/

import java.util.List;
import java.util.ArrayList; 
import java.util.Collections;

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

  List<Integer> morrisPostorder(TreeNode root){
     
     List<Integer> ans = new ArrayList<>();

       while(root != null){
          
           if(root.right == null){
             ans.add(root.data);
             root = root.left;
           }
           else{

             TreeNode curr = root.right;
              while(curr.left != null && curr.left != root){
                curr = curr.left;
              }
              if(curr.left == null){
                 ans.add(root.data);
                 curr.left = root;
                 root = root.right;
              }
              else{
                 curr.left = null;
                 root = root.left;
              }
           }
       }

       // reverse the list for post order 
       Collections.reverse(ans);

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

    List<Integer> ans = tree.morrisPostorder(root);

    System.out.println(ans);


    }
}
