import java.util.Deque;
import java.util.ArrayDeque;

class Solution{
  
  // function to get the minimum sliding window 
     int[] slidingWindowMinimum(int[] arr , int k){
        
         int n = arr.length;
         Deque<Integer> deque = new ArrayDeque<>();
         int possibleWindow = (n+1) - k;

         int[] ans = new int[possibleWindow];
         int index = 0; 

         for(int i = 0; i < k; i++){
            if(deque.isEmpty()){
              deque.offerLast(i);
            }
            else{
               while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
                 deque.pollLast();
               }
               deque.offerLast(i);
            }
         }
         ans[index] = arr[deque.peekFirst()];

         for(int i = k; i < n; i++){

            int windowSize = i - deque.peekFirst() + 1;
            if(windowSize > k){
               deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
              deque.pollLast();
            }
            deque.offerLast(i);
            index++;
            ans[index] = arr[deque.peekFirst()];

         }
         return ans;
     }
     
     void display(int[] arr){
        for(int i = 0; i < arr.length; i++){
           System.out.print(arr[i] + " ");
        }
        System.out.println();
     }
}

public class SlidingWindowMinimumDemo {
    public static void main(String[] args) {
  
      int[] arr  = {4, 3, 7, 5, 2, 3, 1, 8, 7};
      int k = 4;

      int[] ans = new Solution().slidingWindowMinimum(arr , k);
  
     new Solution().display(arr);
     new Solution().display(ans);

      
    }
}
