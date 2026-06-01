import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

// Time Complexity : O(n)
/*
 ias code me maine har element ka alag se next and previous smallest element calculate kar ke kisi array me 
 store karne ki bajay , maine direct run time pe hi jab element pop hota h uasi time pe uas current element ka 
 next and previous smallest element get kr ke window size calculate kar leta hun iasse fayada ye h ki alag se 
 2 array create karne ki need nahi pari , jo pahle ek array next smallest element store karta tha or dusra 
 vala array previous smallest element store kar ke rakhta tha
*/
class Solution {
    public int[] maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
          int[] ans = new int[n];
          Arrays.fill(ans, Integer.MIN_VALUE);
     
        
        for(int i = 0; i < n; i++){
            
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
              
               int nextSmallest = i;
               int current = stack.pop();
               int previousSmallest = stack.isEmpty() ? -1 : stack.peek();
               int windowSize = nextSmallest - previousSmallest - 1;
              ans[windowSize - 1] = Math.max(ans[windowSize - 1] , arr[current]);
              
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
          
            int current = stack.pop();
            int nextSmallest = n;
            int previousSmallest = stack.isEmpty() ? -1 : stack.peek();
            int windowSize = nextSmallest - previousSmallest - 1;
          ans[windowSize - 1] = Math.max(ans[windowSize - 1] , arr[current]);
          
        }
        
        for(int i = n - 1; i > 0; i--){
          
          ans[i - 1] = Math.max(ans[i - 1] , ans[i]);
          
        }
        
       return ans; 
    }
    void dis(int[] arr){
       for(int elm : arr){
         System.out.print(elm + " ");
       }
       System.out.println();
    }
}
public class MaximumOfMinEveryWindowSizeM4{
  public static void main(String[] args){
    
    int[] arr = new int[]{10, 20, 15 , 50, 10, 70, 30};
      Solution obj = new Solution();
      
      int[] ans = obj.maxOfMins(arr);
      
      obj.dis(arr);
      obj.dis(ans);
      
  }
}
