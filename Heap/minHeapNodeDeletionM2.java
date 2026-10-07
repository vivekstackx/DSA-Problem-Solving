import java.util.*;

class Heap {
    private int[] heapArr;
    private int heapSize;

    Heap(int[] heapArr, int heapSize) {
        this.heapArr = heapArr;
        this.heapSize = heapSize;
    }

    private void swap(int parent, int child) {
        int temp = heapArr[parent];
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    // Iterative heapifyDown (O(1) aux space)
    private void heapifyDown(int parent) {
        while (true) {
            int min = parent;
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;

            if (leftChild < heapSize && heapArr[leftChild] < heapArr[min]) {
                min = leftChild;
            }

            if (rightChild < heapSize && heapArr[rightChild] < heapArr[min]) {
                min = rightChild;
            }

            if (min != parent) {
                swap(parent, min);
                parent = min; // Move down to child position
            } else {
                break;
            }
        }
    }

    // Delete root node from min heap
    void deleteNode() {
        if (heapSize == 0) {
            System.out.println("Heap underflow !");
            return;
        }
        int deletedData = heapArr[0];
        heapArr[0] = heapArr[heapSize - 1];
        heapSize--;

        heapifyDown(0);

        System.out.println(deletedData + " Data deleted from Heap.");
    }

    void display() {
        if (heapSize == 0) {
            System.out.println("Heap underflow !");
            return;
        }

        for (int i = 0; i < heapSize; i++) {
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Valid Min Heap array
        int[] heapArr = {10, 14, 13, 18, 17, 15, 50};
        int heapSize = 7;

        Heap heap = new Heap(heapArr, heapSize);

        heap.deleteNode();
        heap.deleteNode();
        heap.deleteNode();
        heap.deleteNode();
        heap.deleteNode();
        heap.deleteNode();
        heap.deleteNode();

        heap.display();
    }
}
