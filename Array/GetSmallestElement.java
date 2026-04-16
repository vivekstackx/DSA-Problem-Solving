
class Solution {

    // geting the smallest element from array
    int getMinValue(int[] arr) {
          int min = Integer.MAX_VALUE;
        if (arr == null || arr.length == 0) {
            return min;
        }
        
        for (int i = 0; i < arr.length; i++) {
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
