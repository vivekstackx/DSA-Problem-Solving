
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

    // Right Rotation (R)
    private Node rightRotation(Node imbalanceNode) {

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
    private Node leftRotation(Node imbalanceNode) {

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

    private Node insert(Node root, int key) {

        // Normal BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }

        return balanceTree(root, key);
    }

    private Node balanceTree(Node root, int key) {

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        int balanceFactor = lh - rh;

        // Left Heavy
        if (balanceFactor > 1) {

            // LL Case
            if (key < root.left.data) {
                return rightRotation(root);
            }

            // LR Case
            else {
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }

        // Right Heavy
        if (balanceFactor < -1) {

            // RR Case
            if (key > root.right.data) {
                return leftRotation(root);
            }

            // RL Case
            else {
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }

        // No rotation required update the height of current root
        root.height = Math.max(lh, rh) + 1;

        return root;
    }

    // O(1) height lookup
    private int getHeight(Node root) {

        return root == null ? 0 : root.height;
    }
    
    
    
    
      public Node insertToAVL(Node root, int key) {

        return insert(root, key);
    }
}
