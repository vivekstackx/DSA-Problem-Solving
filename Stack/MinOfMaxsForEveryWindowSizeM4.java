import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


class Solution {
     
    // Time Complexity : O(n)

  // function to get the minimum of maximum for every window sizes
         int[] minOfMaxs(int [] arr){

              int n = arr.length;
              int[] ans = new int[n];
              Arrays.fill(ans , Integer.MAX_VALUE);
              
              Deque<Integer> stack = new ArrayDeque<>();
              
              for(int i = 0; i < n; i++){
                
                while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                  
                   int nextGreater = i;
                   int current = stack.pop();
                   int previousGreater = stack.isEmpty() ? -1 : stack.peek();
                   int windowSize = nextGreater - previousGreater - 1;
                   
                   ans[windowSize - 1] = Math.min(ans[windowSize - 1] , arr[current]);
                }
                stack.push(i);
              }
              while(!stack.isEmpty()){
                int current = stack.pop();
                int nextGreater = n;
                int previousGreater = stack.isEmpty() ? -1 : stack.peek();
                int windowSize = nextGreater - previousGreater - 1;
                
                ans[windowSize - 1] = Math.min(ans[windowSize - 1] , arr[current]);
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

public class MinOfMaxsForEveryWindowSizeM4{
   public static void main(String[] args){

       Solution obj = new Solution();
    
       int[] arr = {10, 20, 15, 50, 10, 70, 30};

       int[] ans = obj.minOfMaxs(arr);

       obj.dis(arr);
       obj.dis(ans);
   }    
}
