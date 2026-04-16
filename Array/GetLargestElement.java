
class Solution {

    // geting the largest element from array
    int getMaxValue(int[] arr) {
         int max = Integer.MIN_VALUE;
        if (arr == null || arr.length == 0) {
            return max;
        }

        for (int i = 0; i < arr.length; i++) {
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
