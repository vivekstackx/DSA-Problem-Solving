import java.util.*;

class Heap {
    private int heapSize;

    private void swap(int parent, int child, int[] heapArr) {
        int temp = heapArr[parent];
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    private void heapifyUp(int[] heapArr, int child) {
        while (child > 0) {
            int parent = (child - 1) / 2;

            if (heapArr[parent] < heapArr[child]) {
                swap(parent, child, heapArr);
                child = parent;
            } else {
                break;
            }
        }
    }

    private void insert(int child, int[] heapArr) {
        heapifyUp(heapArr, child);
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

    private void deleteNode(int[] heapArr) {
        if (heapSize <= 0) return;

        swap(0, heapSize - 1, heapArr);

        heapSize--;

        heapifyDown(0, heapArr);
    }

    void sort(int[] arr) {
        // Step 1: Convert array to Max-Heap (Insertion method)
        for (int i = 0; i < arr.length; i++) {
            insert(i, arr);
        }

        // Step 2: Delete top repeatedly to sort in ascending order
        heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            deleteNode(arr);
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
