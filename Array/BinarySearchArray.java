
class Solution {

    // binary search
    int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

          //  int mid = left + (right - left) / 2; for big array (recommended)

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }
}

public class BinarySearchArray {

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 2, 6, 7, 8, 9, 10, 11, 17, 20, 22, 30, 32, 50 };

        int target = 1;

        System.out.println(obj.binarySearch(arr, target));
    }
}
