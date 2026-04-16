
class Solution {

    // geting the largest element from array
    int getMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;

    }
}

public class GetLargestElement{
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 5, 2, 8, 1 };

        System.out.println(obj.getMaxValue(arr));
    }
}
