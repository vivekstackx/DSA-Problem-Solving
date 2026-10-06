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

    private void heapifyDown(int parent) {
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
            swap(parent, largest);
            heapifyDown(largest);
        }
    }

    // Delete the root node from max heap
    void deleteNode() {
        if (heapSize == 0) {
            System.out.println("Heap underflow !");
            return;
        }

        int temp = heapArr[0];
        heapArr[0] = heapArr[heapSize - 1];
        heapSize--;

        heapifyDown(0);

        System.out.println(temp + " Data deleted from Heap.");
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
        int[] heapArr = {30, 18, 15, 14, 17, 13, 10};
        int heapSize = 7;

        Heap heap = new Heap(heapArr, heapSize);

        for (int i = 0; i < 8; i++) {
            heap.deleteNode();
        }

        heap.display();
    }
}
