
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

  void flattenTreeToLinkedList(TreeNode root){

        while(root != null){

           if(root.left == null){
              root = root.right;
           }
           else{

             TreeNode curr = root.left;

             while(curr.right != null){
               curr = curr.right;
             } 

             curr.right = root.right;
             root.right = root.left;
             root.left = null;
             root = root.right; 
            
           }
        }
    
  }


  void display(TreeNode root){
     
      if(root == null) return;

      TreeNode curr = root;
      while(curr != null){
        System.out.print(curr.data + " ");
        curr = curr.right;
      }
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

    tree.flattenTreeToLinkedList(root);
    
    tree.display(root);


    }
}
