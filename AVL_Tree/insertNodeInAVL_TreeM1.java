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
        
        return BalanceTree(root , key);
    }
    
    private Node BalanceTree(Node root , int key){
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        int balanceFactor = lh - rh;
        
        if(balanceFactor > 1){
            
            // right Rotation (R)
            if(key < root.left.data){
                return rightRotation(root);
            }
            else{
                // right left Rotation (RL)
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }
        
        if(balanceFactor < -1){
            
            // left Rotation (L)
            if(key > root.right.data){
                return leftRotation(root);
            }
            else{
                // left Right Rotation (LR)
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        
        return root;
    }
    
    private int getHeight(Node root){
     
       if(root == null) return 0;
       
       return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }
    
    private Node leftRotation(Node imbalanceNode){
        
        Node child = imbalanceNode.right;
        imbalanceNode.right = child.left;
        child.left = imbalanceNode;
        
        return child;
    }
    
    private Node rightRotation(Node imbalanceNode){
        
        Node child = imbalanceNode.left;
        imbalanceNode.left = child.right;
        child.right = imbalanceNode;
        
        return child;
    }
    
    
    
    
    public Node insertToAVL(Node root, int key) {
    
        return insert(root , key);
        
    }
}
