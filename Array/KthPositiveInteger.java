
class Solution {

    // function to get Kth missing number (using binary search)
    int getKthMissing(int[] arr, int KthNo) {
        int start = 0;
        int end = arr.length - 1;
        int index = end + 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missingNo = arr[mid] - (mid + 1);

         if (missingNo >= KthNo) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index + KthNo;
    }
}

public class KthPositiveInteger {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = new int[] { 2, 3, 7, 11 };
        int KthNo = 7;

        int missingNo = obj.getKthMissing(arr, KthNo);
        System.out.println(missingNo);
    }
}
