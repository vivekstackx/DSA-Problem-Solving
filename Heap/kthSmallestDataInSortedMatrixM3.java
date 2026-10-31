class Pair{
    int row, column, data;
    Pair(int row , int column , int data){
        this.row = row;
        this.column = column;
        this.data = data;
    }
}

class Solution {

    private boolean isValidPosition(int[][] matrix , int row , int column){
   
          return (row >= matrix.length || column >= matrix[row].length) ? false : true;
    }

    public int kthSmallest(int[][] matrix, int k) {
        
         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));
       

         HashSet<String> set = new HashSet<>();

         pq.offer(new Pair(0 , 0 , matrix[0][0])); 
         set.add(0 + "," + 0); 

         int kthSmallest = 0;

         while(!pq.isEmpty()){

             Pair pair = pq.poll(); 
             
             kthSmallest = pair.data; 
             k--;

             if(k == 0) return kthSmallest;

             // right direction 
             if(isValidPosition(matrix , pair.row , pair.column + 1) && !set.contains(pair.row + "," + (pair.column + 1))){
                 pq.offer(new Pair(pair.row , pair.column +  1 , matrix[pair.row][pair.column + 1])); 
                 set.add(pair.row + "," + (pair.column + 1));
                 
             }

             // row direction
             if(isValidPosition(matrix , pair.row + 1 , pair.column) && !set.contains((pair.row + 1) + ","+pair.column)){
                pq.offer(new Pair(pair.row + 1 , pair.column , matrix[pair.row + 1][pair.column]));
                 set.add((pair.row + 1) + "," + pair.column);
             }

         }
      
         return -1; // kth smallest not exists

    }
}
