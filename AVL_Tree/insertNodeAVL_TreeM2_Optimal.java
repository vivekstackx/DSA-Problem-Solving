/* Structure of AVL Tree Node
class Node {
public:
    int data;
    int height;
    Node *left, *right;

    Node(int x) {
        data = x;
        height = 1;
        left = right = null;
    }
}; */

class Solution {
    
    // right rotation (R)
     private Node rightRotation(Node imbalanceNode){
         
         Node child = imbalanceNode.left;
         imbalanceNode.left = child.right;
         child.right = imbalanceNode;
         
         imbalanceNode.height--;
         
         return child;
     }
     
     // left rotation (L) 
     private Node leftRotation(Node imbalanceNode){
          
          Node child = imbalanceNode.right;
          imbalanceNode.right = child.left;
          child.left = imbalanceNode;
          
          imbalanceNode.height--;
          
          return child;
     }
     
     
   private Node insert(Node root , int key){
       
        if(root == null){
            return new Node(key);
        }
        
        if(key < root.data){
            root.left = insert(root.left , key);
        }
        else{
            root.right = insert(root.right , key); 
        }
        
        return balanceTree(root , key);
   }  
     

    private Node balanceTree(Node root , int key){
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right); 
        
        int balanceFactor = lh - rh;
        
        if(balanceFactor > 1){
            
            if(key < root.left.data){
              
                return rightRotation(root);
            }
            else{
                root.left = leftRotation(root.left);
                Node child = rightRotation(root);
                
                child.height = Math.max(getHeight(child.left) , getHeight(child.right)) + 1;
                
                return child;
            }
            
        }
        
        if(balanceFactor < -1){
            
            if(key > root.right.data){
                return leftRotation(root); 
            }
            else{
                root.right = rightRotation(root.right); 
                Node child = leftRotation(root);
                
                child.height = Math.max(getHeight(child.left) , getHeight(child.right)) + 1;
                
                return child;
            }
        }
        
        root.height = Math.max(lh , rh) + 1;
        
        return root;
    }
    
    private int getHeight(Node root){
        
        return root == null ? 0 : root.height;
    }
     
     
    public Node insertToAVL(Node root, int key) {
      
        return insert(root, key);
        
    }
}
