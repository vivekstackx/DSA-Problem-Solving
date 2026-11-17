
class Solution{
   
   boolean isPossible(int[] arr){
     
     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

      int sum = 0; 

      for(int i = 0; i < arr.length; i++){
        
         maxHeap.offer(arr[i]); 
         sum = sum + arr[i];
      }

      while(true){

         int maxValue = maxHeap.poll(); 

          if(maxValue == 1) return true; 
 

         int remSum = sum - maxValue;
         int element = maxValue - remSum;

         if(element < 1) break;

         sum = maxValue;

           maxHeap.offer(element);
      } 

      return false;
   }
}

public class Main {
    public static void main(String[] args) {
       

       Solution obj = new Solution(); 

       int[] arr = {10 , 25 , 1 , 37};

       System.out.println(obj.isPossible(arr));
    }
}
