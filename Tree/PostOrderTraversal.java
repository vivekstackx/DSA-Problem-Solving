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
    
    void postOrderTraversal(Node root){
        
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    
}

class Main{
    public static void main(String[] args){
        Tree tree = new Tree();
        
        Node root = null;
        System.out.println("Enter the root node : ");
        root = tree.createTree();
        
        System.out.println("PostOrder : ");
        tree.postOrderTraversal(root);
        
    }
}
