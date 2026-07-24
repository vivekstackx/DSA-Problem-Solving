import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;


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
    
    void levelOrderTraverse(Node root){
      
          if(root == null){
              System.out.println("Tree Empty !");
              return;
          }
          Queue<Node> queue = new ArrayDeque<>();
          queue.offer(root);
          
          while(!queue.isEmpty()){
              int size = queue.size();
              
              while(size > 0){
                  Node curr = queue.poll();
                  System.out.print(curr.data + " ");
                  size--;
                  
                  if(curr.left != null){
                      queue.offer(curr.left);
                  }
                  if(curr.right != null){
                      queue.offer(curr.right);
                  }
              }
              System.out.println();
          }
          
    }
    
   
}

class Main{
    public static void main(String[] args){
        Tree tree = new Tree();
        
        Node root = null;
        System.out.println("Enter the root node : ");
        root = tree.createTree();
        
        System.out.println("Level Order : ");
        tree.levelOrderTraverse(root);
        
    }
}
