
class Solution{
   
   private void helper(int[] arr, int index){
       
          if(index == arr.length) return;

          helper(arr , index + 1); 

          System.out.print(arr[index] + " ");
   }

   public void reverseArray(int[] arr){
       helper(arr , 0);
   }
}

public class Main {
    public static void main(String[] args) {
      
        new Solution().reverseArray(new int[]{10 , 20, 30, 40, 50});
    }
}
