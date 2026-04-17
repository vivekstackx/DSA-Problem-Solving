
class Solution {

    // function to get the third largest element from array (using 3 loop)
    int getThirdMax(int[] arr) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        if (arr == null || arr.length < 3) {
            return -1;
        }

        // get the first largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
            }
        }
        // get the second largest element
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != max1) {
                if (arr[j] > max2) {
                    max2 = arr[j];
                }
            }
        }
        // get the third largest element
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] != max1 && arr[k] != max2) {
                if (arr[k] > max3) {
                    max3 = arr[k];
                }
            }
        }
       return max3 == Integer.MIN_VALUE ? -1 : max3;
    }

    // function to get the third largest element (using 1 loop)
    int getThirdMaxOptimized(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        if (arr == null || arr.length < 3) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && arr[i] != max1) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3 && arr[i] != max1 && arr[i] != max2) {
                max3 = arr[i];
            }
        }
        return max3 == Integer.MIN_VALUE ? -1 : max3;
    }
}

public class GetThirdLargest {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 10, 7, 9, 3, 11, 14, 8, 6 };

        System.out.println(obj.getThirdMax(arr));

        System.out.println("--------------");

        System.out.println(obj.getThirdMaxOptimized(arr));
    }
}
