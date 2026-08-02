/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    private int leftMostPosition, rightMostPosition;
    
      Solution(){
          leftMostPosition = rightMostPosition = 0;
      }
      
   private void getPosition(Node root , int position){
       
          if(root == null){
              return;
          }
          leftMostPosition = Math.min(leftMostPosition , position);
          rightMostPosition = Math.max(rightMostPosition , position);
          
          getPosition(root.left , position - 1);
          getPosition(root.right , position + 1);
          
     }
      
    public ArrayList<Integer> bottomView(Node root) {
        
         ArrayList<Integer> list = new ArrayList<>();
         
         if(root == null){
             return list;
         }
         
          leftMostPosition = rightMostPosition = 0;
          
          getPosition(root , 0);
          
          int bottomViewLength = rightMostPosition - leftMostPosition + 1;
          
          int[] ans = new int[bottomViewLength];
          Queue<Node> queue = new ArrayDeque<>();
          Queue<Integer> queueIndex = new ArrayDeque<>();
          
          queue.offer(root);
          queueIndex.offer(Math.abs(leftMostPosition));
          
          while(!queue.isEmpty()){
              // current level proccessing
              int size = queue.size();
              
              while(size > 0){
                  Node curr = queue.poll();
                  int index = queueIndex.poll();
                  size--;
                  // replace the node from top to bottom
                  ans[index] = curr.data;
                  
                  if(curr.left != null){
                      queue.offer(curr.left);
                      queueIndex.offer(index - 1);
                  }
                  
                  if(curr.right != null){
                      queue.offer(curr.right);
                      queueIndex.offer(index + 1);
                  }
              }
          }
          
           for(int i = 0; i < ans.length; i++){
               list.add(ans[i]);
           }
          return list;
    }
}
