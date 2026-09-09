

class Solution {
    
    
    // funtion to get the each common node between two BST
     private ArrayList<Integer> helper(Node root1 , Node root2){
         
         ArrayList<Integer> ans = new ArrayList<>();
         
         Deque<Node> stack1 = new ArrayDeque<>();
         Deque<Node> stack2 = new ArrayDeque<>();
         
         
         Node curr1 = root1;
         Node curr2 = root2;
         
         while(curr1 != null || curr2 != null){
             
             if(curr1 != null){
                 stack1.push(curr1);
                 curr1 = curr1.left;
             }
             if(curr2 != null){
                 stack2.push(curr2);
                 curr2 = curr2.left;
             }
             
         }
         
         while(!stack1.isEmpty() && !stack2.isEmpty()){
             
             Node x = stack1.peek();
             Node y = stack2.peek();
             
             // common node
             if(x.data == y.data){
                 ans.add(x.data);
                 
                 Node temp1 = stack1.pop().right;
                 Node temp2 = stack2.pop().right;
                 
                 while(temp1 != null || temp2 != null){
                     
                     if(temp1 != null){
                         stack1.push(temp1);
                         temp1 = temp1.left;
                     }
                     if(temp2 != null){
                         stack2.push(temp2);
                         temp2 = temp2.left;
                     }
                     
                 }
             }
             else{
                 
                 if(x.data < y.data){
                     Node temp = stack1.pop().right;
                     
                     while(temp != null){
                         stack1.push(temp);
                         temp = temp.left;
                     }
                 }
                 else{
                     Node temp = stack2.pop().right;
                     
                     while(temp != null){
                         stack2.push(temp);
                         temp = temp.left;
                     }
                 }
             }
         }
         
         
         return ans;
     }
    
    
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        
         return helper(r1 , r2);
         
        
    }
}
