class Solution {

    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>(); 
        
         PriorityQueue<Integer> group = new PriorityQueue<>();
         
         for(int i = 0; i < k; i++){
             
              group.offer(arr[i]); 
              
             if(i == k - 1){
                 ans.add(group.peek());
             }
             else{
             ans.add(-1);     
             }
              
            
         }
         
         for(int i = k; i < arr.length; i++){
            
             if(arr[i] > group.peek()){
                 
                 group.poll(); 
                 group.offer(arr[i]);
                 
                
             }
             ans.add(group.peek());
         }
         
         
         return ans; 
    }
}
