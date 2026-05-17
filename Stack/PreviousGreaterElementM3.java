import java.util.Arrays;
import java.util.Stack;

class Solution{
     // function to find the previous greater element in the array
      int[] getNext(int[] arr){
          int[] ans = new int[arr.length];
          Arrays.fill(ans , -1);
           Stack<Integer> stack = new Stack<>();
           
           for(int i = arr.length - 1; i >= 0 ; i--){
              
              while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                ans[stack.pop()] = arr[i];
              }
              stack.push(i);
           }
           return ans;
         
   
      }
       
      // print Array
      void printArray(int[] arr){
         for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " "); 
         }
         System.out.println();
      }
}



public class PreviousGreaterElementM3{
     public static void main(String[] args) {
        int[] arr = {8, 6, 4, 7, 4, 9, 10, 8, 12};
          
        Solution obj = new Solution();
        
        obj.printArray(arr); 
        
        int[] ans = obj.getNext(arr);
        
        obj.printArray(ans);
        
          
      
     }
}
