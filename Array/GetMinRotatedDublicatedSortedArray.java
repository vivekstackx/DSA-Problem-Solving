class Solution {
    public int findMin(int[] nums) {
        // implement binary search
           int start = 0;
           int end = nums.length - 1;

           while(start < end){
              int mid = start + (end - start) / 2;

              // min in right side 
               if(nums[mid] > nums[end]){
                 start = mid + 1;
               }
               // min in left
               else if(nums[mid] < nums[end]){
                  end = mid;
               }
               // if nums[mid] == nums[end] dublicate found
               else {
                  end--;
               }
           }
           return nums[start];
    }
}

public class GetMinRotatedDublicatedSortedArray {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = new int[] { 10, 1, 10, 10, 10 };

        int min = obj.findMin(arr);
        System.out.println(min);
    }
}
