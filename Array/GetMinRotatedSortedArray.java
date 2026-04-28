class Solution {
    public int findMin(int[] nums) {
        // implement binary search
           int start = 0;
           int end = nums.length - 1;
           int min = nums[0];

           while(start <= end){
               int mid = start + (end - start) / 2;
              // left side sorted
               if(nums[mid] >= nums[0]){
                   start = mid + 1;
               }
               // right side sorted
               else{
                  min = nums[mid];
                  end = mid - 1;
               }
           }
           return min;
    }
}

public class GetMinRotatedSortedArray {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = new int[] { 4, 6, 8, 10, 2 };

        int min = obj.findMin(arr);
        System.out.println(min);
    }
}
