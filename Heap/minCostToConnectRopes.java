
class Solution {
    public int minCost(int[] arr) {
        // code here
        Queue<Integer> pq = new PriorityQueue<>();
        
        // store each array data into priority queue.
        for(int i = 0; i < arr.length; i++){
            pq.offer(arr[i]);
        }
        
        int minCost = 0; 
        
        while(pq.size() > 1){
            
            int firstMin = pq.poll();
            int secondMin = pq.poll(); 
            
            int rops = firstMin + secondMin;
            
            minCost = minCost + rops;
            
            pq.offer(rops); 
            
        }
        
        return minCost; 
    }
}
