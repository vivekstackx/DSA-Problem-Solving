import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int days = i - stack.peek();
                ans[stack.peek()] = days;
                stack.pop();
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

public class DailyTempretures{
   public static void main(String[] args){
     int [] arr = {73,74,75,71,69,72,76,73};
     Solution obj =  new Solution();
     
     int[] ans = obj.dailyTemperatures(arr);
     
     obj.printArray(arr);
     obj.printArray(ans); 
     
   }
}
