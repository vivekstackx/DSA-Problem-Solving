
class Solution {
    // left shifting
   private void leftShiftElements(int[] arr, int size, int position) {
        for (int i = position; i < size; i++) {
            arr[i - 1] = arr[i];
        }
    }

    // delete element at specific position
    int deleteAtSpecificPos(int[] arr, int size, int position) {
        if (arr == null || size <= 0) {
            return size;
        }
        if (!(position > 0 && position <= size)) {
            return size;
        }
        
        leftShiftElements(arr, size, position);

        return size - 1;

    }

    // print array
    void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class DeleteElementAtIndex {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int capacity = 5;
        int[] arr = new int[capacity];

        int size = 5;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println("Before deletion : ");
        obj.printArray(arr, size);

        int position = 3;

        size = obj.deleteAtSpecificPos(arr, size, position);

        System.out.println("After deletion : ");
        obj.printArray(arr, size);

    }

}
