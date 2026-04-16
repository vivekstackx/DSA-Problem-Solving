
class Solution {

    // geting the smallest element from array
    int getMinValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;

    }
}

public class GetSmallestElement {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 2, 8, 1 };

        System.out.println(obj.getMinValue(arr));
    }
}
