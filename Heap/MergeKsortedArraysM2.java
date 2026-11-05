class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        
          PriorityQueue<Integer> minHeap = new PriorityQueue<>();
          
          for(int i =  0; i < mat.length; i++){
              for(int j = 0; j < mat[i].length; j++){
                  minHeap.offer(mat[i][j]);
              }
          }
          
          ArrayList<Integer> ans = new ArrayList<>(); 
          
          while(!minHeap.isEmpty()){
              ans.add(minHeap.poll());
          }
          
          return ans;
        
    }
}
