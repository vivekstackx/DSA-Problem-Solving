/*
leetcode 987 -----------------------------
ye v normal vertical traversal hi h bas ek condition h ---
iasme jab same level( same row) and same vertical line (same column) pe anne vale sabhi 
node ko accending order me sort karna h 
 */

class Solution {
    private int leftMostPosition , rightMostPosition;

    private void getPosition(TreeNode root , int position){
      
         if(root == null){
             return;
         }

         leftMostPosition = Math.min(leftMostPosition , position);
         rightMostPosition = Math.max(rightMostPosition , position);

         getPosition(root.left , position - 1);
         getPosition(root.right , position + 1);
         

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
    
        getPosition(root , 0);
        
        int totalVerticalLine = rightMostPosition - leftMostPosition + 1;
        // group of same level and same vertical line point
        Map<Integer, List<Integer>> groupOfRowColmMap = new HashMap<>();

        for(int i = 0; i < totalVerticalLine; i++){
            
            groupOfRowColmMap.put(i , new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> indexQueue = new ArrayDeque<>();
        
        queue.offer(root);
        indexQueue.offer(Math.abs(leftMostPosition));

        while(!queue.isEmpty()){

            // current level proccessing...
            int size = queue.size();

            while(size > 0){

                TreeNode currNode = queue.poll();
                int index = indexQueue.poll();
                size--;

                groupOfRowColmMap.get(index).add(currNode.val);
                
                if(currNode.left != null){
                    queue.offer(currNode.left);
                    indexQueue.offer(index - 1);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                    indexQueue.offer(index + 1);
                }

            }
           // Traverse HashMap for sorting data when current level execution will completed.
            for(int i = 0; i < totalVerticalLine; i++){
             
             List<Integer> list = groupOfRowColmMap.get(i); 

            if(!list.isEmpty()){
                
                Collections.sort(list);
                
                List<Integer> sortedList = list;

                for(Integer data : sortedList){

                    ans.get(i).add(data);
                }
                // reset the group of list in map
                groupOfRowColmMap.put(i , new ArrayList<>());
                
            }
        }


        }
    
       return ans;
        
    }
} 
