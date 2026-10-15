class Solution {
    public int findKthLargest(int[] nums, int k) {

       Queue<Integer> pq = new PriorityQueue<>();
       
       // make a group and push k data in group for geting kth largest data
       for(int i = 0; i < k; i++){
          pq.offer(nums[i]);
       }

       for(int i = k; i < nums.length; i++){
          
            if(nums[i] > pq.peek()){

                pq.poll();
                pq.offer(nums[i]);
            }
       }

       return pq.peek();

    }
}
