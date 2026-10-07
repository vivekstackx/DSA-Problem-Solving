import java.util.*;

class Heap {
    private int heapSize;

    private void swap(int parent, int child, int[] heapArr) {
        int temp = heapArr[parent];
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    private void heapifyDown(int parent, int[] heapArr) {
        int largest = parent;
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;

        if (leftChild < heapSize && heapArr[leftChild] > heapArr[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && heapArr[rightChild] > heapArr[largest]) {
            largest = rightChild;
        }

        if (largest != parent) {
            swap(parent, largest, heapArr);
            heapifyDown(largest, heapArr);
        }
    }

    // Convert array to Max Heap in O(N) time
    private void buildMaxHeap(int[] arr) {
        heapSize = arr.length;

        // Start from last non-leaf node down to root
        for (int i = (heapSize / 2) - 1; i >= 0; i--) {
            heapifyDown(i, arr);
        }
    }

    void sort(int[] arr) {
        // Step 1: Build Max-Heap in O(N) time
        buildMaxHeap(arr);

        // Step 2: Extract top repeatedly (O(N log N) sorting phase)
        for (int i = 0; i < arr.length; i++) {
            swap(0, heapSize - 1, arr);
            heapSize--;
            heapifyDown(0, arr);
        }
    }

    void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {8, 9, 3, 2, 6, 7, 1, 5, 4};

        Heap heap = new Heap();

        System.out.print("Unsorted data : ");
        heap.display(arr);

        heap.sort(arr);

        System.out.print("Sorted data   : ");
        heap.display(arr);
    }
}
