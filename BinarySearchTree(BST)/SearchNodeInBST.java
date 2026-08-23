
class Solution {
    public boolean searchBST(Node root, int key) {
       
       // key not persent 
       if(root == null) return false;
       
       if(root.data == key) return true;
       
       if(key < root.data){
           return search(root.left , key);
       }
       else{
           return search(root.right , key);
       }
    }
}
