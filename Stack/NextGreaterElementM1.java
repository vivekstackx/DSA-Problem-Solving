import java.util.Arrays;

class Solution{
     // function to find the next greater element in the array
      int[] getNext(int[] arr){
          int[] ans = new int[arr.length];
          Arrays.fill(ans, -1);

          for(int i = 0; i < arr.length; i++){
             for(int j = i + 1; j < arr.length; j++){
                   if(arr[j] > arr[i]){
                      ans[i] = arr[j];
                      break;
                   }
             }
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



public class NextGreaterElementM1{
     public static void main(String[] args) {
        int[] arr = {8, 6, 4, 7, 4, 9, 10, 8, 12};
          
        Solution obj = new Solution();
        
        obj.printArray(arr); 
        
        int[] ans = obj.getNext(arr);
        
        obj.printArray(ans);
        
          
      
     }
}
