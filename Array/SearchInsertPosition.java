
class Solution {

    // function to get the insertion index position (using binary search)
    int getInsertionPosition(int[] arr, int target) {

        if (arr == null) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;

        int index = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                index = mid;
                end = mid - 1;
            }
        }
        return index;
    }
}

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 1, 4, 6, 8, 10, 14, 16, 18 };

        int target = 5;

        int index = obj.getInsertionPosition(arr, target);

        System.out.println("Element " + target + " position is : " + index);
    }
}
