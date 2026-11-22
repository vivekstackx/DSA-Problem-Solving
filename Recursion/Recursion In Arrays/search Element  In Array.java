
class Solution{
    
    private boolean helper(int[] arr , int target , int index){
        
          if(index == arr.length) return false; 

          if(arr[index] == target) return true;

          return helper(arr , target , index + 1);
    }

    public boolean isPersent(int[] arr , int target){
       return helper(arr , target , 0);
    }
}

public class Main {
    public static void main(String[] args) {
     
       int[] arr = {10 , 20 , 30 , 40, 50};
       int target = 40;

       System.out.print(new Solution().isPersent(arr , target)); 
    }
}
