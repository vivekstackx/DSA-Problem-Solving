import java.util.Stack;

class Solution{
  
   // stock span problem
    int[] stockSpan(int[] prices){
      
         Stack<Integer> stack = new Stack<>();
         int[] ans = new int[prices.length];
          int n = prices.length;
          
         for(int i = n - 1; i >= 0; i--){
           
            while(!stack.isEmpty() && prices[i] >= prices[stack.peek()]){
              ans[stack.peek()] = stack.peek() - i;
              stack.pop();
            }
            stack.push(i);
         } 
         while(!stack.isEmpty()){
            int index = stack.pop();
           ans[index] = index + 1;
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

public class StockSpanAlgo2 {
    public static void main(String[] args) {
       int[] prices = { 3, 5, 10, 20, 52, 100, 80, 55, 70, 60, 75, 85};
       
       Solution obj = new Solution();
        
        obj.printArray(prices);
        
       int[] ans = obj.stockSpan(prices);
       
       obj.printArray(ans);
       
       
    }
}
