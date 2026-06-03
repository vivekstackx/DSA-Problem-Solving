import java.util.Arrays;

class Solution {
    // Time Complexity : O(n3)

    // function to get the minimum of maximum for every window size
    int[] minOfMaxs(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        // executes for every window size
        for (int i = 1; i <= n; i++) {

            // possible windows for current window size
            for (int j = 0; (n - j) >= i; j++) {
                
                int max = Integer.MIN_VALUE;
                // get max of current window
                for (int k = j; k < j + i; k++) {
                    max = Math.max(max, arr[k]);
                }
                ans[i - 1] = Math.min(max, ans[i - 1]);
            }
        }
        return ans;
    }

    // function to display the array elements
    void dis(int[] arr) {

        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}

public class MinOfMaxsForEveryWindowSizeM1 {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 10, 20, 15, 50, 10, 70, 30 };

        int[] ans = obj.minOfMaxs(arr);

        obj.dis(arr);
        obj.dis(ans);
    }
}
