
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
         
         for(int i = 0; i < n; i++){
           for(int j = i+1; j < n; j++){
              if(temperatures[j] > temperatures[i]){
                int days = j - i;
                ans[i] = days;
                break;
              }
           }
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

public class DailyTempretures3{
   public static void main(String[] args){
     int [] arr = {73,74,75,71,69,72,76,73};
     Solution obj =  new Solution();
     
     int[] ans = obj.dailyTemperatures(arr);
     
     obj.printArray(arr);
     obj.printArray(ans); 
     
   }
}
