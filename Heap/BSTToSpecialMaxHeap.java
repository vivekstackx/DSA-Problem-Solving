/* Binary Tree Node Structure
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution {
    private static int index; 
    
    private static int countNode(Node root){
       
         if(root  == null) return 0; 
         
         return countNode(root.left) + countNode(root.right) + 1; 
    }
    
    private static void inorder(Node root, int[] inorderArr){
        
        if(root == null) return; 
        
        inorder(root.left , inorderArr); 
        
        inorderArr[index] = root.data; 
        index++; 
        
        inorder(root.right , inorderArr); 
    }
    
    private static void postorder(Node root , int[] inorderArr){
       
         if(root == null) return; 
         
         postorder(root.left , inorderArr);
         postorder(root.right , inorderArr); 
         
         root.data = inorderArr[index]; 
         index++; 
    }
    
    public static void convertToMaxHeap(Node root) {
        // code here
       int totalNode = countNode(root); 
       
       int[] inorderArr = new int[totalNode]; 
       
        index = 0; 
        
        inorder(root , inorderArr);
        
        index = 0; 
       
       postorder(root , inorderArr);
    }
}
