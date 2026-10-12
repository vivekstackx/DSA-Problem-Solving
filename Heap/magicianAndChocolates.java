
public class Solution {
    public static int maximumChocolates(ArrayList<Integer> arr,int k){
        
  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
  
  // store the each list data into priority queue 
   for(int data : arr){
     pq.offer(data);
   }

   int time = k;
   
   int maxChocolates = 0; 

   while(time > 0 && !pq.isEmpty()){
      
      int chocolate = pq.poll(); 
      
      maxChocolates = maxChocolates + chocolate;

        int halfChocolate = chocolate / 2;
       // if chocolate exits 
       if(halfChocolate > 0){
          pq.offer(halfChocolate);
       }

       time--;
   }
   
    return maxChocolates;

    }
}
