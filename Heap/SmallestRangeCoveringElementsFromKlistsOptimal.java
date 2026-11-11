class Pair{
  int row, column , data; 
    
    Pair(int row , int column, int data){
        this.row = row;
        this.column = column;
        this.data = data;
    }
}

class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        
         PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.data , b.data));
         
         int minValue = 0; 
         int maxValue = Integer.MIN_VALUE; 
         int diff = 0; 

         // we have to store the first element in min-heap of each given list.
         
         for(int i = 0; i < nums.size(); i++){

              if(nums.get(i).size() > 0){
                 
                 int firstElement = nums.get(i).get(0);

                 minHeap.offer(new Pair(i , 0, firstElement));
                 
                 maxValue = Math.max(maxValue , firstElement);
              }
         }
         
         int minRange = 0; 
         int maxRange = 0; 
         int rangeDiff = Integer.MAX_VALUE; 


         while(true){

            Pair pair = minHeap.poll(); 
            
            minValue = pair.data;
            
            if((maxValue - minValue) < rangeDiff){
                minRange = minValue;
                maxRange = maxValue;
                rangeDiff = maxValue - minValue;
            }

            if(pair.column + 1 >= nums.get(pair.row).size()){
                break; // range can't not be defined !
            }
            
            int nextValue = nums.get(pair.row).get(pair.column + 1);

            minHeap.offer(new Pair(pair.row , pair.column + 1 , nextValue));

            maxValue = Math.max(maxValue , nextValue);
            
         }
         
         return new int[]{minRange , maxRange};

    }
}
