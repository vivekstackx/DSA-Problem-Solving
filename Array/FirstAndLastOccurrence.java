
class Solution {

    // find the first and last occurance in array (using linearSearch)
    int[] getRange(int[] arr, int target) {
        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] { first, last };
    }

    // function to get the first occurance of target element
      int getFirstOccurance(int[] nums , int target){
           int firstOcr = -1;
           // implement binary search
            int start = 0;
            int end = nums.length - 1;

             while(start <= end){
                  int mid = start + (end - start)/2;

                  if(nums[mid] == target){
                     firstOcr = mid;
                     end = mid - 1;
                  }
                  else if(nums[mid] > target){
                      end = mid - 1;
                  }
                  else {
                     start = mid + 1;
                  }
             }
             return firstOcr;
      }

      // function to get the last occurance of target element
       int getLastOccurance(int[] nums , int target){
            int lastOcr = -1;

            // implement binary search
             int start = 0;
             int end = nums.length - 1;
             while(start <= end){
                  int mid = start + (end - start) / 2;

                  if(nums[mid] == target){
                      lastOcr = mid;
                      start = mid + 1;
                  }
                  else if(nums[mid] > target){
                     end = mid - 1;
                  }
                  else {
                     start = mid + 1;
                  }
             }
             return lastOcr;
       }

    // function to get the first and last occurance (using binay search)
    public int[] searchRange(int[] nums, int target) {
        
        if(nums== null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int firstOcr = getFirstOccurance(nums , target);
        if(firstOcr == -1){
            return new int[]{-1, -1};
        }
        int lastOcr = getLastOccurance(nums , target);
        return new int[]{firstOcr , lastOcr};
    }
}

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 3, 2, 7, 3, 7, 8, 1, 9, 7, 22, 12 };

        int target1 = 7;

        int[] ans1 = obj.getRange(arr, target1);

        System.out.println("first occurance is : " + ans1[0]);
        System.out.println("last occurance is : " + ans1[1]);

        System.out.println("----------------");

        int[] sortedArr = { 2, 4, 8, 8, 8, 8, 8, 9, 12, 12, 13, 16, 18, 18, 19, 20, 22 };

        int target2 = 8;

        int[] ans2 = obj.searchRange(sortedArr, target2);

        System.out.println("first occurance is : " + ans2[0]);
        System.out.println("last occurance is : " + ans2[1]);

    }
}
