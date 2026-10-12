 
class Solution {
    public int lastStoneWeight(int[] stones) {
        
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       // store each array stones in priority queue 
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){

            int firstStone = pq.poll();
            int secondStone = pq.poll(); 

            int weight = firstStone - secondStone;

            if(weight > 0){
                pq.offer(weight); 
            }
        }

        return pq.isEmpty() ? 0 : pq.poll(); 
    }
}
