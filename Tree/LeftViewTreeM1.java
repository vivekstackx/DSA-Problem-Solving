class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
         ArrayList<Integer> list = new ArrayList<>();
         if(root == null){
             return list;
         }
         Queue<Node> queue = new ArrayDeque<>();
         queue.offer(root);
         
         while(!queue.isEmpty()){
             // current level
             
              // store first node of each level in list
             list.add(queue.peek().data);
             
             int size = queue.size();
            
             while(size > 0){
                 
                Node temp = queue.poll();
                size--;
                
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
             }
         }
         
         return list;
    }
}
