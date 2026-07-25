import java.util.Scanner;

class Node{
    Node left;
    int data;
    Node right;
     Node(int data){
         this.data = data;
         this.left = null;
         this.right = null;
     }
}

class Tree{
     Scanner scanner;
     private int count , max;
     
       Tree(){
         scanner = new Scanner(System.in);
       }
       
    Node createTree(){
       int currData = scanner.nextInt();
       
       if(currData == -1){
           return null;
       }
       Node newNode = new Node(currData);
       System.out.println("enter left child of " + currData);
       newNode.left = createTree();
       System.out.println("enter right child of " + currData);
       newNode.right = createTree();
       return newNode;
    }
    
   int heightOfBinaryTreeM1(Node root){
      if(root == null){
          return 0;
      }
      
      int leftHeight = heightOfBinaryTreeM1(root.left);
      int rightHeight = heightOfBinaryTreeM1(root.right);
      
      return Math.max(leftHeight , rightHeight) + 1;
     
   }
   int heightOfBinaryTreeM2(Node root){
       
       if(root == null){
           return -1;
       }
      int leftHeight = heightOfBinaryTreeM2(root.left);
      int rightHeight = heightOfBinaryTreeM2(root.right);
      
      return Math.max(leftHeight , rightHeight) + 1;
       
   }
   
    private void preOrder(Node root){
        if(root == null){
            return;
        }
        count++;
        max = Math.max(max , count);
        preOrder(root.left);
        preOrder(root.right);
        count--;
    }
   
    int heightOfBinaryTreeM3(Node root){
       count = 0;
       max = 0;
       
       preOrder(root);
       return max;
   }
   
   
    
}

class Main{ 
    public static void main(String[] args){
        Tree tree = new Tree();
        
        Node root = null;
        System.out.println("Enter the root node : ");
        root = tree.createTree();
        
        int heightM1 = tree.heightOfBinaryTreeM1(root);
         int heightM2 = tree.heightOfBinaryTreeM2(root);
          int heightM3 = tree.heightOfBinaryTreeM3(root);
        
        
        System.out.println(heightM1);
         System.out.println(heightM2);
          System.out.println(heightM3);
        
        
    }
}
