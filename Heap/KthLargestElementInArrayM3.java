class Solution {
    public int findKthLargest(int[] nums, int k) {

       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       for(int data : nums){
         pq.offer(data);
       }

       int KthLargest = Integer.MIN_VALUE;

       while(k > 0){
          KthLargest = pq.poll(); 
          k--;
       }
    
       return KthLargest;

    }
}
