


class Solution {
    private int index; 
    
    private Node helper(int[] post , int lowerBound , int upperBound){
       
        if(index == -1) return null; 
        
        if(!(lowerBound < post[index] && post[index] < upperBound)) return null;
        
        Node newNode = new Node(post[index]);
        index--;
        
        newNode.right = helper(post , newNode.data , upperBound);
        newNode.left = helper(post , lowerBound , newNode.data);
        
        return newNode;
    }
    
    Node constructTree(int[] post) {
    
        int lowerBound = Integer.MIN_VALUE;
        int upperBound = Integer.MAX_VALUE;
        index = post.length - 1; 
        
      return helper(post , lowerBound , upperBound);
        
        
    }
}
