

class Solution {

    // shift element in right side
    private void shiftElements(int[] arr, int size, int position) {
        for (int i = size - 1; i >= position - 1; i--) {
            arr[i + 1] = arr[i];
        }
    } 
    
    // insert element in specific position in array
    int insertAtSpecificPosition(int[] arr, int size, int position, int newElement) {
        if (arr == null) {
            return size;
        }
        int capacity = arr.length;

        if (size >= capacity) {
            return size;
        }
        if (!(position >= 1 && position <= size + 1)) {
            return size;
        }

        // right shift
        shiftElements(arr, size, position);

        // store new element at given position
        arr[position - 1] = newElement;

        return size + 1;

    }

    // print array
    void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class InsertAtIndex {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int capacity = 7;
        int[] arr = new int[capacity];

        int size = 4;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;

        int position = 2;
        int newElement = 100;

        System.out.println("Before insertion : ");
        obj.printArray(arr, size);

        size = obj.insertAtSpecificPosition(arr, size, position, newElement);

        System.out.println("After insertion : ");
        obj.printArray(arr, size);

    }
}
