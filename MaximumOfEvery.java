import java.util.ArrayList;
import java.util.Arrays;

class Solution{
   
       int[] maxOfMins(int[] arr){
        
        int n = arr.length;
        int[] ans = new int[n];
        
        Arrays.fill(ans , Integer.MIN_VALUE);
      
        
        for(int i = 0; i < n; i++){
          
           int windowPosition = 0;
           int min = Integer.MAX_VALUE;
           
           for(int j = i; j < n; j++){
             
             min = Math.min(min , arr[j]);
             ans[windowPosition] = Math.max(ans[windowPosition] , min);
             windowPosition++;
           }
           
        }
        return ans;
    }
    
    
    
    
     void dis(int[] arr){

        for(int x : arr){
            System.out.print(x + " ");
        }

        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
      int[] arr = {10, 20, 15, 50, 10, 70 , 30};
      
      Solution obj = new Solution();
      
      int[] ans = obj.maxOfMins(arr);
      
      obj.dis(arr);
      obj.dis(ans);
    }
}
