/*
  Example For testing...
  -> {10, 20, 30, 40, 50, 60,70, 80}
  -> {15, 10, 7, 9, 15, 14, 12, 8, 15}
*/

class Solution {

    // function to get second smallest element from array (using 2 loop)
    int getSecondMin(int[] arr) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        if (arr == null || arr.length < 2) {
            return min2;
        }
        // get first smallest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min1) {
                min1 = arr[i];
            }
        }
        // get second smallest element
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != min1) {
                if (arr[j] < min2) {
                    min2 = arr[j];
                }
            }
        }

        return min2;
    }

    // function to get the second smallest element from array (using 1 loop)
    int getSecondMinOptimized(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        if (arr == null || arr.length < 2) {
            return min2;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2 && arr[i] != min1) {
                min2 = arr[i];
            }
        }
        return min2;
    }
}

public class GetSecondSmallest {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 10, 5, 12, 6, 10, 9, 3, 7, 8, 12, 4, 12, 16, 2, 16, 9, 8 };

        System.out.println(obj.getSecondMin(arr));

        System.out.println("---------------");

        System.out.println(obj.getSecondMinOptimized(arr));
    }
}
