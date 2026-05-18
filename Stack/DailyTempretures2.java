import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

       for(int i = n-1; i >= 0; i--){
          
           while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
             stack.pop();
           }
           if(!stack.isEmpty()){
             ans[i] = stack.peek() - i;
           }
           stack.push(i);
       }
        return ans;
    }
     void printArray(int[] arr){
      for(int i = 0; i < arr.length; i++){
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}

public class DailyTempretures2{
   public static void main(String[] args){
     int [] arr = {5, 10, 9, 3, 7, 7, 8, 9, 12};
     Solution obj =  new Solution();
     
     int[] ans = obj.dailyTemperatures(arr);
     
     obj.printArray(arr);
     obj.printArray(ans); 
     
   }
}
