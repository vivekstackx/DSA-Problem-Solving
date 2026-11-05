class Pair{
    int data ,row , column;
    
     Pair(int data , int row , int column){
         this.data = data;
         this.row = row; 
         this.column = column; 
     }
}

class Solution {
    
    private boolean isValidPosition(int[][] mat , int  row , int column){
       
         return column < mat[row].length ? true : false;    
    }
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
         PriorityQueue<Pair> minHeap = new PriorityQueue<>((a , b) -> Integer.compare(a.data , b.data));
         
         for(int i = 0;  i < mat.length; i++){
             minHeap.offer(new Pair(mat[i][0], i, 0));
         }
         
         ArrayList<Integer> ans = new ArrayList<>(); 
         
         while(!minHeap.isEmpty()){
             
             Pair node = minHeap.poll(); 
             
             ans.add(node.data);
             
             if(isValidPosition(mat , node.row , node.column + 1)){
                 minHeap.offer(new Pair(mat[node.row][node.column + 1] , node.row, node.column +  1));
             }
             
         }
         
         return ans; 
         
         
    }
}
