
class Solution {

    // function to get the third smallest element from array (using 3 loop)
    int getThirdMin(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

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
        // get third smallest element
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != min1 && arr[k] != min2) {
                if (arr[k] < min3) {
                    min3 = arr[k];
                }
            }
        }
        return min3 == Integer.MAX_VALUE ? -1 : min3;
    }

    // function to get the third smallest element from array (using 1 loop)
    int getThirdMinOptimized(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min1) { // layer 1 check
                min3 = min2;
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2 && arr[i] != min1) { // layer 2 check 
                min3 = min2;
                min2 = arr[i];
            } else if (arr[i] < min3 && arr[i] != min1 && arr[i] != min2) { // layer 3 check
                min3 = arr[i];
            }
        }
        return min3 == Integer.MAX_VALUE ? -1 : min3;
    }
}

public class GetThirdSmallest {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 10, 7, 9, 3, 11, 14, 8, 6 };

        System.out.println(obj.getThirdMin(arr));

        System.out.println("-----------");

        System.out.println(obj.getThirdMinOptimized(arr));

    }
}
