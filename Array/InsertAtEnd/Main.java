 package InsertAtEnd;

class Solution {

    // insert element at ending position
    int insertAtEnd(int[] arr, int size, int newElement) {
        if (arr == null) {
            return size;
        }
        int capacity = arr.length;
        if (size >= capacity) {
            return size;
        }
        arr[size] = newElement;

        return size + 1;
    }

    void printArray(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int capacity = 5;
        int arr[] = new int[capacity];

        int size = 2;

        arr[0] = 10;
        arr[1] = 20;

        System.out.println("Before Insertion : ");
        obj.printArray(arr, size);

        System.out.println("After Insertion : ");
        int newElement = 100;
        size = obj.insertAtEnd(arr, size, newElement);

        obj.printArray(arr, size);

    }
}
