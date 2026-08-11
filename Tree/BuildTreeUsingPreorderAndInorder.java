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

   private TreeNode helper(int[] preOrder, int[] inOrder, int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd){

       if(inOrderStart > inOrderEnd){
         return null;
       }

       int currData = preOrder[preOrderStart];

       TreeNode newNode = new TreeNode(currData);
       
       int position = getPosition(inOrder, currData, inOrderStart, inOrderEnd);

      newNode.left = helper(preOrder, inOrder, inOrderStart, position - 1, preOrderStart + 1, preOrderStart + (position - inOrderStart));
      
      newNode.right = helper(preOrder, inOrder, position + 1, inOrderEnd, (preOrderStart + (position - inOrderStart)) + 1, preOrderEnd );

      return newNode;
   }
   
   TreeNode buildTree(int[] preOrder , int[] inOrder){

    int preOrderStart = 0;
    int preOrderEnd = preOrder.length - 1;
    int inOrderStart = 0;
    int inOrderEnd = inOrder.length - 1;

    return helper(preOrder, inOrder, inOrderStart, inOrderEnd, preOrderStart, preOrderEnd);
      
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
      
      int[] preOrder = {1, 2, 4, 8, 12, 9, 10, 11, 5, 13, 3, 6, 14, 7};
      int[] inOrder =  {8, 12, 4, 10, 9, 11, 2, 13, 5, 1, 6, 14, 3, 7};
     
      Tree tree = new Tree();

      TreeNode root = tree.buildTree(preOrder, inOrder);

      tree.display(root);

    }
}
