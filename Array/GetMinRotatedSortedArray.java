class Solution {

    public int findMin(int[] nums) {
        // implement binary search
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // min in right side
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // min in left side
            else {
                end = mid;
            }

        }
        return nums[start];
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
