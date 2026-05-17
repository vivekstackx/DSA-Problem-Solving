import java.util.Stack;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
  
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans , -1); 

      HashMap<Integer, Integer> map = new HashMap<>();
      
       Stack<Integer> stack = new Stack<>();
      
     
       for(int i = 0; i < nums2.length; i++){
            
              while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                  map.put(nums2[stack.pop()] , nums2[i]);
                  
              }
              stack.push(i);
       }
       
        // check greater element persent or not 
         for(int i = 0; i < nums1.length; i++){
            Integer isGreater = map.get(nums1[i]); 
            if(isGreater != null){
              ans[i] = isGreater;
            }
         }
        
       return ans;
         
    }
}

public class NextGreaterWithTwoArray{
  public static void main(String[] args){
      int[] nums1 = {4,1,2};
      int[] nums2 = {1,3,4,2};
      
     int[] ans = new Solution().nextGreaterElement(nums1, nums2);
     
     for(int i = 0; i < ans.length; i++){
        System.out.print(ans[i] + " ");
     }
  }
}
