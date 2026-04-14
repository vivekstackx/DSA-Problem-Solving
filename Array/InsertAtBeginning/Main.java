// package Array;

class InsertAtBeginning {

    // insert at beginning in fixed-size array
    int insertAtStart(int[] arr, int size, int newElement) {
        int capacity = arr.length;

        if (size >= capacity) {
            return size;
        }

        // shift elements right
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        // insert at first position
        arr[0] = newElement;

        return size + 1;
    }

    // print only valid elements
    void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        InsertAtBeginning obj = new InsertAtBeginning();
        int capacity = 5;
        int[] arr = new int[capacity];

        // initial valid size
        int size = 3;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println("Before insertion:");
        obj.printArray(arr, size);

        int newElement = 100;

        size = obj.insertAtStart(arr, size, newElement);

        System.out.println("After insertion:");
        obj.printArray(arr, size);
    }
}
