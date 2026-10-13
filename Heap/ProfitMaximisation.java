public class Solution {
    public int solve(int[] A, int B) {
         
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         // store each array data into heap 
         
         for(int seat : A){
             pq.offer(seat);
         }
         
         int tiket = B;
         int maxProfit = 0; 
         
         while(tiket > 0 && !pq.isEmpty()){
             
             int maxSeat = pq.poll(); 
             
             maxProfit = maxProfit + maxSeat;
             
             maxSeat = maxSeat - 1;
             
             if(maxSeat > 0){
                 pq.offer(maxSeat);
             }
             
             tiket--;
             
         }
         
         return maxProfit;
    }
}
