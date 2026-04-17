
class Solution {

    // swap data
    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // function to revrse the array
    void reverseArray(int[] arr) {
        if (arr == null) {
            return;
        }

        if (arr.length == 0) {
            return;
        }

        int start = 0;
        int end = arr.length -1 ;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // print array
    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


public class ReverseArray {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 10, 7, 9, 3, 11, 4, 8, 6 };

        System.out.println("Before reverse : ");
        obj.printArray(arr);

        obj.reverseArray(arr);

        System.out.println("After reverse : ");
        obj.printArray(arr);

    }
}
