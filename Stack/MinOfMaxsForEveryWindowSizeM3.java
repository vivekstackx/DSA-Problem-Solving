import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


class Solution {
     
    // Time Complexity : O(n)

    // function to gets the next greater element for each element
      private int[] getNextGreater(int[] arr){
            int n = arr.length;
            int[] ans = new int[n]; 

            Deque<Integer> stack = new ArrayDeque<>();

            for(int i = 0; i < n; i++){
                while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                    ans[stack.pop()] = i;
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                 ans[stack.pop()] = n;
            }
            return ans;
       }

       // function to gets the previous greater element for each element
        private int[] getPreviousGreater(int[] arr){

               int n = arr.length;
               int[] ans = new int[n];
               Deque<Integer> stack = new ArrayDeque<>();

               for(int i = n - 1; i >= 0; i--){
                  while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                     ans[stack.pop()] = i;
                  }
                  stack.push(i);
               }
               while(!stack.isEmpty()){
                 ans[stack.pop()] = -1;
               }
               return ans;
  }

  // function to get the minimum of maximum for every window sizes
         int[] minOfMaxs(int [] arr){
          
            int n = arr.length;
            int[] ans = new int[n];
            Arrays.fill(ans , Integer.MAX_VALUE);


            int[] nextGreater = getNextGreater(arr);
            int[] previousGreater = getPreviousGreater(arr);
          
            for(int i = 0; i < n; i++){

                int ng = nextGreater[i];
                int pg = previousGreater[i];
                int windowSizes = ng - pg - 1;

                  ans[windowSizes - 1] = Math.min(ans[windowSizes - 1], arr[i]);
            }
            
            for(int i = n - 1; i > 0; i--){
              ans[i - 1] = Math.min(ans[i - 1] , ans[i]);
            }

            return ans;
        }

       void dis(int[] arr){
         for(int data : arr){
            System.out.print(data + " ");
         }
         System.out.println();
       }
}

public class MinOfMaxsForEveryWindowSizeM3 {
   public static void main(String[] args){

       Solution obj = new Solution();
    
       int[] arr = {10, 20, 15, 50, 10, 70, 30};

       int[] ans = obj.minOfMaxs(arr);

       obj.dis(arr);
       obj.dis(ans);
   }    
}
