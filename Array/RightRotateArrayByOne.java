
class Solution {

    // function to rotate the array by one
    void rotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // store last element
        int end = arr[arr.length - 1];

        // right shift
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        // update first element to last element
        arr[0] = end;
    }

    // print array
    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class RightRotateArrayByOne {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = { 12, 2, 7, 9, 5, 4, 8 };

        System.out.println("Before Rotation : ");
        obj.printArray(arr);

        obj.rotateArray(arr);

        System.out.println("After Rotation : ");
        obj.printArray(arr);

    }
}
