import java.util.Stack;
/*
 daily tempretures vale ias sawal me ham har element ke next greater check kar ke uaske bich ka distance get karte h ,
 vahi stock span vale sawal me just iske ulte h , usme ham har element ke previous greater element check karte h or uaske bich 
 ka distance get karte h 
*/
class Solution{
   // stock span problem 
    int[] stockSpan(int[] prices){
         Stack<Integer> stack = new Stack<>();
         int[] ans = new int[prices.length];
         
        for(int i = 0; i < prices.length; i++){
            
             while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]){
                stack.pop();
             }
             if(stack.isEmpty()){ // Greater element not found
                ans[i] = i + 1;
             }
             else{ // Greater element found
               ans[i] = i - stack.peek();
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

public class StockSpanAlgo {
    public static void main(String[] args) {
       int[] prices = {3, 5, 10, 20, 52, 100, 80, 55, 70, 60, 75, 85};
       
       Solution obj = new Solution();
        
        obj.printArray(prices);
        
       int[] ans = obj.stockSpan(prices);
       
       obj.printArray(ans);
       
       
    }
}
