import java.util.Arrays;

class Solution{
    // Time Complexity : O(n2)

    // function to get the minimum of maximums for every window sizes
      int[] minOfMaxs(int[] arr){
        
         int n = arr.length;
         int[] ans = new int[n];
         Arrays.fill(ans , Integer.MAX_VALUE);


         for(int i = 0; i < n; i++){
             int index = 0;
             int max = Integer.MIN_VALUE;

             for(int j = i; j < n; j++){
               max = Math.max(max , arr[j]);
               ans[index] = Math.min(max , ans[index]);
               index++;
             }
         }

         return ans;
      }
         // function to display the array elements
    void dis(int[] arr) {
        int n = arr.length;

        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}


public class MinOfMaxsForEveryWindowSizeM2 {
   public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 10, 20, 15, 50, 10, 70, 30 };

        int[] ans = obj.minOfMaxs(arr);

        obj.dis(arr);
        obj.dis(ans);
    }
}
