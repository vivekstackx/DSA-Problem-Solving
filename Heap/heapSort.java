import java.util.*;

class Heap {
    private int heapSize; 

    void swap(int[] heapArr, int child, int parent) {
        int temp = heapArr[parent]; 
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp; 
    }

    private void heapify(int[] heapArr, int parent) {
        while (true) {
            int max = parent;

            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2; 

            if (leftChild < heapSize && heapArr[leftChild] > heapArr[max]) {
                max = leftChild;
            }

            if (rightChild < heapSize && heapArr[rightChild] > heapArr[max]) {
                max = rightChild;
            }

            if (max == parent) break;

            swap(heapArr, max, parent); 
            parent = max; // move to downward 
        }
    }

    // Convert into max-heap 
    private void convertMaxHeap(int[] heapArr) {
        int nonLeaf = (heapArr.length / 2) - 1; 
      
        for (int i = nonLeaf; i >= 0; i--) {
            heapify(heapArr, i);
        }
    }

    private void deleteNode(int[] heapArr) {
        swap(heapArr, 0, heapSize - 1); 
        heapSize--;

        heapify(heapArr, 0); 
    }
 
    // Delete each node from max-heap 
    private void deleteEachNode(int[] heapArr) {
        for (int i = 1; i < heapArr.length; i++) {
            deleteNode(heapArr);
        }
    }

    void sort(int[] heapArr) {
        heapSize = heapArr.length; 
        // Convert max-heap
        convertMaxHeap(heapArr);

        // Delete each data from max-heap 
        deleteEachNode(heapArr);
    }   

    void display(int[] heapArr) {
        for (int i = 0; i < heapArr.length; i++) {
            System.out.print(heapArr[i] + " ");
        }
        System.out.println(); 
    } 
}

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(); 

        int[] heapArr = {3, 7, 2, 1, 5, 8, 6, 9, 12}; 

        heap.display(heapArr); 

        heap.sort(heapArr); 

        heap.display(heapArr); 
    }
}
