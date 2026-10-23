class Solution {
    public int sumBetweenK1K2(int[] arr, int k1, int k2) {
        // code here
        
          PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
          
          // find k1 smallest 
          
          for(int i = 0; i < k1; i++){
              
              maxHeap.offer(arr[i]);
          }
          
          for(int i = k1; i < arr.length; i++){
              
              if(arr[i] < maxHeap.peek()){
                  
                  maxHeap.poll();
                  maxHeap.offer(arr[i]);
              }
          }
          
          int sum1 = 0; 
          
          while(!maxHeap.isEmpty()){
              
              sum1 = sum1 + maxHeap.poll();
          }
          
         // find k2 smallest 
         
         for(int i = 0; i < k2; i++){
             
             maxHeap.offer(arr[i]);
         }
         
         for(int i = k2; i < arr.length; i++){
             
             if(arr[i] < maxHeap.peek()){
                 
                 maxHeap.poll();
                 maxHeap.offer(arr[i]);
             }
         }
         
         int sum2 = 0; 
         
         maxHeap.poll();
         
         while(!maxHeap.isEmpty()){
             
             sum2 = sum2 + maxHeap.poll();
         }
         
         
         return sum2 - sum1;
    }
}
