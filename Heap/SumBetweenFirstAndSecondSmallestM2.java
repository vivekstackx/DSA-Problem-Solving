class Solution {
    public int sumBetweenK1K2(int[] arr, int k1, int k2) {
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < k1; i++){
            pq1.offer(arr[i]);
        }    
        
        for(int i = 0; i < k2; i++){
            pq2.offer(arr[i]);
        }
        
        // geting k1Th smallest 
        for(int i = k1; i < arr.length; i++){
            
            if(arr[i] < pq1.peek()){
                
                pq1.poll();
                pq1.offer(arr[i]);
            }
        }
        
        // geting k2Th smallest 
        for(int i = k2; i < arr.length; i++){
            
            if(arr[i] < pq2.peek()){
                
                pq2.poll();
                pq2.offer(arr[i]);
            }
        }
        
        // geting the sum of k1Th smallest group
         int sum1 = 0; 
         
         while(!pq1.isEmpty()){
             
             sum1 = sum1 + pq1.poll(); 
         }
         
         // geting the sum of k2Th smallest group
         int sum2 = 0; 
         
         pq2.poll();
         
         while(!pq2.isEmpty()){
             
             sum2 = sum2 + pq2.poll(); 
         }
        
        return sum2 - sum1;
        
    }
}
