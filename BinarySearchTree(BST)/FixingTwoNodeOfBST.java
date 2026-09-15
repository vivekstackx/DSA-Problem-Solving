/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    
    private int index;
    
    private void inorder(Node root , List<Integer> list){
       
         if(root == null) return;
         
         inorder(root.left , list);
         list.add(root.data);
         inorder(root.right , list);
    }
    
    private void  inorderFixingTwoNode(Node  root , List<Integer> list){
         
          if(root == null) return;
          
          inorderFixingTwoNode(root.left , list);
          
          root.data = list.get(index);
          index++;
          
          inorderFixingTwoNode(root.right , list);
    }
    
    public Node correctBST(Node root) {
    
        List<Integer> list = new ArrayList<>();
        
        inorder(root , list);
        
        int first = -1;
        int second = -1;
        
        for(int i = 0; i < list.size() - 1; i++){
            
            if(list.get(i + 1) < list.get(i)){
                // problem occurs at first time
                if(first == -1 && second == -1){
                    first = i;
                    second = i + 1;
                }
                // problme occurs at second time 
                else{
                    second = i + 1;
                    break;
                }
            }
        }
        
        // swap problem occurs nodes data 
         int temp = list.get(first);
         list.set(first , list.get(second));
         list.set(second , temp);
         
         inorderFixingTwoNode(root , list);
         
         
         return root;
    }
};
