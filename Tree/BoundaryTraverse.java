import java.util.List;
import java.util.ArrayList;

/*
 step 1 :) sabse pahle root node ko print kijie 
 step 2 :) fir root ke left se start kijie or jab tak leaf node na aa jaye tb tak aage padhte rahe or data ko print v karte rahe.
 step 3 :) fir root node se start kare or tree me jitna leaf node h sabko print kare left to right 
 step 4 :) fir root ke right se start kijie or jab tak leaf node na aa jaye tab tak aage badhte rhe or returning 
 time me data ko print karte rahe dhyan rahe leaf node ko print nahi karna h 

 Note : dhyan rhe leaf node ko left and right boundry print karte time leaf node ko print nahi karna h
 Note : order important h iasi order me kaam karna h [ root data + left boundary node + leaf node + right boundary node ]
 
*/

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

   private boolean leftSubTreeBoundry(TreeNode root , List<Integer> ans){
      
         if(root == null) return false;

         if(root.left == null && root.right == null) return true;

         ans.add(root.data);

         boolean left = leftSubTreeBoundry(root.left , ans);
         if(left) return true;

         boolean right = leftSubTreeBoundry(root.right , ans);
         if(right) return true;

         return false;
   }

   private void leafNode(TreeNode root , List<Integer> ans){

       if(root == null) return;

       if(root.left == null && root.right == null){
         ans.add(root.data);
         return;
       }

       leafNode(root.left , ans);
       leafNode(root.right , ans);
   }

   private boolean rightSubTreeBoundry(TreeNode root , List<Integer> ans){

       if(root == null) return false;

       if(root.left == null && root.right == null) return true; 

       boolean right = rightSubTreeBoundry(root.right , ans);
       if(right){
         ans.add(root.data);
         return true;
       }

       boolean left = rightSubTreeBoundry(root.left , ans);
       if(left){
        ans.add(root.data);
        return true;
       }

     return false;
   }
  
   List<Integer> boundaryTraverse(TreeNode root){

      List<Integer> ans = new ArrayList<>(); 

      if(root == null) return ans;
     
      // step 1 ) add root node
      ans.add(root.data); 
      
      // step 2 ) add only left boundary node except leaf node
      leftSubTreeBoundry(root.left , ans);
      
      // step 3 ) add leaf node 
      if(root.left != null || root.right != null){
        leafNode(root , ans);
      }

      // step 4 ) add only right boundary node in reverse order except leaf node 
      rightSubTreeBoundry(root.right , ans);


      return ans;

   }

}


public class Main {
    public static void main(String[] args) {
      
        TreeNode root = null;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(14);
        root.left.left.right = new TreeNode(8);
        root.left.left.right.left = new TreeNode(15);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.left = new TreeNode(12);
        root.right.right.right.left.left = new TreeNode(11);
        root.right.right.right.left.right = new TreeNode(13); 

        Tree tree = new Tree(); 

        List<Integer> ans = tree.boundaryTraverse(root);

        System.out.println(ans);


    }
}
