
class Solution{
   
    private void helper(int[] arr , int index , int sum , List<Integer> temp){
       
         if(index == arr.length){
            System.out.println(sum + " : " + temp);
            return;
         }

         // included 
          temp.add(arr[index]);
          helper(arr , index + 1 , sum + arr[index] , temp);
          temp.remove(temp.size() - 1);

          // not included
          helper(arr , index + 1 , sum , temp);
    }

    void sumOfSubSet(int[] arr){
        
        List<Integer> temp = new ArrayList<>();

        helper(arr , 0 , 0 , temp); 
    }
}

public class Main {
    public static void main(String[] args) {
      
       new Solution().sumOfSubSet(new int[]{3, 4, 5});
       
    }
}
