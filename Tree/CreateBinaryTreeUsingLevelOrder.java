import java.util.ArrayDeque;
import java.util.Queue;
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
    
    Node createTree(){

       Queue<Node> queue = new ArrayDeque<>();
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter the root node : ");
       int rootData = scanner.nextInt();
       
       if(rootData == -1){
            return null;
        }

       Node root = new Node(rootData);
       queue.offer(root);

       while(!queue.isEmpty()){
          
          Node curr = queue.poll();
          System.out.print("Enter the left child of node " + curr.data + " : ");
          int leftChildData = scanner.nextInt();
          
          if(leftChildData != -1){
            Node newNode = new Node(leftChildData);
            curr.left = newNode;
            queue.offer(curr.left);
          }

          System.out.print("Enter the right child of node " + curr.data + " : ");
          int rightChildData = scanner.nextInt();
          System.out.println();
          
          if(rightChildData != -1){
            Node newNode = new Node(rightChildData);
            curr.right = newNode;
            queue.offer(curr.right);
          }

          
       }
    
       return root;

    }
}

public class Main {
    public static void main(String[] args) {
      
      Node root = new Tree().createTree();

    }
}
