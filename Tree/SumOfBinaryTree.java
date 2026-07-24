 int sumOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfBinaryTree(root.left);
        int rightSum = sumOfBinaryTree(root.right);
        
        return leftSum + rightSum + root.data;
    }
