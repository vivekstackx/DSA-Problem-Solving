
class Solution{
   
   private void helper(int[] arr, int index){
       
          if(index == -1) return;

          System.out.print(arr[index] + " ");

          helper(arr , index - 1);
   }

   public void reverseArray(int[] arr){
       helper(arr , arr.length - 1);
   }
}

public class Main {
    public static void main(String[] args) {
      
        new Solution().reverseArray(new int[]{10 , 20, 30, 40, 50});
    }
}
