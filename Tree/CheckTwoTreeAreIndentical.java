
    boolean checkTwoTreesIdentical(Node root1 , Node root2){
        
        if(root1 == null && root2 == null){
        return true;
        }

        if(root1 == null || root2 == null){
        return false;
        }

        if(root1.data != root2.data){
         return false;
       }

        boolean left = checkTwoTreesIdentical(root1.left , root2.left);
        if(left == false) return false;
        boolean right = checkTwoTreesIdentical(root1.right , root2.right);
        if(right == false) return false;
        
        return left && right;
    }
   
  
    
   
