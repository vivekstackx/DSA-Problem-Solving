
class Solution {

    // linear search
    int linearSearch(int[] arr, int target) {
        
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { // found
                return i;
            }
        }
        return -1; // not found
    }
}

public class LinearSearch {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 10, 20, 8, 6, -40, 40 };

        int target = 8;

        System.out.println(obj.linearSearch(arr, target));
    }
}
