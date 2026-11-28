import java.util.List;
import java.util.ArrayList;

class Solution {

    private void powerSet(int[] nums , int index , List<Integer> temp , List<List<Integer>> ans){
       
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
 
        // included
           temp.add(nums[index]);

           powerSet(nums , index + 1 , temp , ans); 
           temp.remove(temp.size() - 1);

        // Not included
           powerSet(nums , index + 1 , temp , ans); 
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        powerSet(nums , 0 , temp , ans); 

        return ans;
    }

}


class Main{
   public static void main(String[] args){
     
       Solution obj = new Solution(); 
       
       int[] arr = {1 , 2 , 3 }; 

       List<List<Integer>> subSequence = obj.subsets(arr);

       System.out.println(subSequence);
   }
}
