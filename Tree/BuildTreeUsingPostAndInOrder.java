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

  private int getPosition(int[] inOrder, int currData, int inOrderStart, int inOrderEnd){

    for(int i = inOrderStart; i <= inOrderEnd; i++){
       
       if(inOrder[i] == currData){
          return i;
       }
    }
    return -1;
  }

   private TreeNode helper(int[] postOrder, int[] inOrder, int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd){

       if(inOrderStart > inOrderEnd){
         return null;
       }

       int currData = postOrder[postOrderStart];

       TreeNode newNode = new TreeNode(currData);
       
       int position = getPosition(inOrder, currData, inOrderStart, inOrderEnd);

      newNode.left = helper(postOrder, inOrder, inOrderStart, position - 1, postOrderEnd + (position - inOrderStart) - 1, postOrderEnd);
      
      newNode.right = helper(postOrder, inOrder, position + 1, inOrderEnd, postOrderStart - 1 , (postOrderEnd + (position - inOrderStart) - 1 ) + 1);

      return newNode;
   }
   
   TreeNode buildTree(int[] postOrder , int[] inOrder){

    int postOrderStart = postOrder.length - 1;
    int postOrderEnd = 0;
    int inOrderStart = 0;
    int inOrderEnd = inOrder.length - 1;

    return helper(postOrder, inOrder, inOrderStart, inOrderEnd, postOrderStart, postOrderEnd);
      
   }

   void display(TreeNode root){
      
      if(root == null) return;

      System.out.print(root.data + " ");
      display(root.left);
      display(root.right);

   }
}
public class Main {
    public static void main(String[] args) {
      
      int[] postOrder = {12, 8, 10, 11, 9, 4, 13, 5, 2, 14, 6, 7, 3, 1};
      int[] inOrder =  {8, 12, 4, 10, 9, 11, 2, 13, 5, 1, 6, 14, 3, 7};
     
      Tree tree = new Tree();

      TreeNode root = tree.buildTree(postOrder, inOrder);

      tree.display(root);

    }
}
