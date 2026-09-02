
class Solution {
    
    private int getPosition(int[] post , int end , int start ){
        
        for(int i = end; i <= start - 1; i++){
            
             if(post[i] > post[start]) return i;
        }
        
        return -1;
    }
    
    private Node helper(int[] post , int start , int end){
     
       if(start < end) return null;
       
       Node newNode = new Node(post[start]);
       
       int position = getPosition(post , end , start);
       
       if(position == -1){
           newNode.left = helper(post , start - 1 , end);
           return newNode;
       }
       else{
           newNode.right = helper(post , start - 1 , position);
           newNode.left = helper(post, position - 1 , end); 
       }
       return newNode;
    }
    
    Node constructTree(int[] post) {
     
       int start = post.length - 1;
       int end = 0;
       
      return helper(post , start , end);
    }
}
