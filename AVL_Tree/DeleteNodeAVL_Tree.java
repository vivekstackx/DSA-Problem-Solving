/* Structure of AVL Tree Node
class Node
{
    int data, height;
    Node left, right;
    Node(int x)
    {
        data = x;
        height = 1;
        left = right = null;
    }
}
*/
class Solution {
   private static Node parent , child;
   
   
   
    // Right Rotation (R)
    private static Node rightRotation(Node imbalanceNode) {

        Node child = imbalanceNode.left;

        imbalanceNode.left = child.right;
        child.right = imbalanceNode;

        // Update height of the imbalance node first
        imbalanceNode.height =
            Math.max(getHeight(imbalanceNode.left),
                     getHeight(imbalanceNode.right)) + 1;

        // Update height of the child node
        child.height =
            Math.max(getHeight(child.left),
                     getHeight(child.right)) + 1;

        return child;
    }

    // Left Rotation (L)
    private static Node leftRotation(Node imbalanceNode) {

        Node child = imbalanceNode.right;

        imbalanceNode.right = child.left;
        child.left = imbalanceNode;

        // Update height of the imbalance node first
        imbalanceNode.height =
            Math.max(getHeight(imbalanceNode.left),
                     getHeight(imbalanceNode.right)) + 1;

        // Update height of the child 
        child.height =
            Math.max(getHeight(child.left),
                     getHeight(child.right)) + 1;

        return child;
    }
   
   private static int getHeight(Node root){
       return root == null ? 0 : root.height;
   }
   
   private static Node getMaxNode(Node root){
       
       if(root.right == null){
           child = root;
           return root.left;
       }
       
       parent = root;
       root.right = getMaxNode(root.right);
       
       return balanceTree(root);
       
   } 
    
    private static Node deleteKey(Node root , int key){
        
        // node not exits 
        if(root == null) return null;
        
        // node exits 
        if(root.data == key){
            
            // leaf node 
            if(root.left == null && root.right == null) return null;
           
           // only one child 
            if(root.left == null || root.right == null){
                
                if(root.left != null) return root.left;
                else return root.right;
            }
            
            // two child 
             parent = null;
             child = null; 
             
            root.left = getMaxNode(root.left);    
            
            if(parent == null){
                
                child.right = root.right;
                root.left = null;
                root.right = null;
                
                return balanceTree(child);
            }
            else{
                
                 child.left = root.left;
                 child.right = root.right;
                 root.left = null;
                 root.right = null;
            
                return balanceTree(child);
            }
            
            
        }
        
        
        if(key < root.data){
            root.left = deleteKey(root.left , key);
        }
        else{ 
            
           root.right = deleteKey(root.right , key);
        }
        
        return balanceTree(root);
    }
    
    
    
    private static Node balanceTree(Node root){
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int balanceFactor = lh - rh;
        
        // R
        if(balanceFactor > 1){
          
           int leftHeightOfChild = getHeight(root.left.left);
           int rightHeightOfChild = getHeight(root.left.right); 
           
           // R
           if(rightHeightOfChild <= leftHeightOfChild){
               
               return rightRotation(root);
           }
           else{
              // LR
              root.left = leftRotation(root.left);
              return rightRotation(root);
           }
        
        }
        
        // L
        if(balanceFactor < -1){
            
            int leftHeightOfChild = getHeight(root.right.left);
            int rightHeightOfChild = getHeight(root.right.right); 
            
            // L
            if(rightHeightOfChild >= leftHeightOfChild){
                
                return leftRotation(root);
            }   
            else{
                // RL
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        
        root.height = Math.max(lh , rh) + 1;
        
        return root;
    }

    
    
    public static Node deleteNode(Node root, int key) {
        
        return deleteKey(root , key); 
        
    }
}
