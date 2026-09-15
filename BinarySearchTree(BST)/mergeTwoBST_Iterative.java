/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> merge(Node r1, Node r2) {
        // code here
        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Node curr1 = r1;
        Node curr2 = r2;
        
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
             
             if(x.data < y.data){
                 ans.add(x.data);
                 
                 Node temp = stack1.pop().right;
                 while(temp != null){
                     stack1.push(temp);
                     temp = temp.left;
                 }
             }
             else if(y.data < x.data){
                ans.add(y.data);
                
                Node temp = stack2.pop().right;
                
                while(temp != null){
                    stack2.push(temp);
                    temp = temp.left;
                }
             }
             else{
                ans.add(x.data);
                ans.add(y.data);
                
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
        }
        
        
        while(!stack1.isEmpty()){
            
            ans.add(stack1.peek().data);
            
            Node curr = stack1.pop().right;
            
            while(curr != null){
                stack1.push(curr);
                curr = curr.left;
            }
        }
        
        while(!stack2.isEmpty()){
            
            ans.add(stack2.peek().data);
            
            Node curr = stack2.pop().right;
            
            while(curr != null){
                stack2.push(curr);
                curr = curr.left;
            }
        }
        
        return ans;
    }
    
}
