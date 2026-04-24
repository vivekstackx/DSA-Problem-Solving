
class Solution {

    // function to get the first occurance of target element
    private int getFirstOccurance(int[] arr, int target) {
        int firstOcr = -1;

        // implement binary search
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                firstOcr = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return firstOcr;
    }

    // function to get the last occurance of target element
    private int getLastOccurance(int[] arr, int target) {
        int lastOcr = -1;

        // implement binary search
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                lastOcr = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lastOcr;
    }

    // function to get the total occurance (using binary search)
    int getOccuranceCount(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int firstOcr = getFirstOccurance(arr, target);
        if (firstOcr == -1) {
            return 0;
        }
        int lastOcr = getLastOccurance(arr, target);
        return lastOcr - firstOcr + 1;
    }

}

public class CountOccurrenceUsingBinarySearch {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 7, 7, 8, 8, 10 };

        int target = 8;

        int count = obj.getOccuranceCount(arr, target);
        System.out.println(count);
    }
}
