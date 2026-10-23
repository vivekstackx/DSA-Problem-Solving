class Solution {
    public int sumBetweenK1K2(int[] arr, int k1, int k2) {
        
        // code here
         Queue<Integer> pq = new PriorityQueue<>();
         
         for(int data : arr){
             pq.offer(data);
         }
         
         int index = 0; 
         
         while(!pq.isEmpty()){
            
            arr[index] = pq.poll();
            index++;
         }
         
         int sum = 0; 
         
         for(int i = k1; i < k2 - 1; i++){
             
             sum = sum + arr[i]; 
         }
         
         return sum;
         
    }
}
