
class Solution {

    // function to get missing element from array
    int getMissingData(int[] arr, int N) {
        if (arr == null || arr.length == 0) {
            return -1; // invalid case
        }
        int totalSum = N * (N + 1) / 2;

        // calculate the total sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        int missingData = totalSum - sum;
        return missingData;
    }
}

public class GetMissingElement {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 1, 2, 4, 5, 6 };
        int N = 6;

        System.out.println(obj.getMissingData(arr, N));
    }
}
