class Solution {

    // traverse each element of Array
    void traverseArrayElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null!");
            return;
        }
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        obj.traverseArrayElement(arr);
    }
}
