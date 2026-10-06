import java.util.*;

class Heap {
    int[] heapArr;
    int lastIndex;
    int capacity;

    Heap(int capacity) {
        this.capacity = capacity;
        this.heapArr = new int[capacity];
        this.lastIndex = -1;
    }

    private void swap(int parentIndex, int childIndex) {
        int temp = heapArr[parentIndex];
        heapArr[parentIndex] = heapArr[childIndex];
        heapArr[childIndex] = temp;
    }

    private void heapifyUp(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;

            if (heapArr[parentIndex] > heapArr[childIndex]) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // Insert node in Min Heap
    void insertNode(int data) {
        if (lastIndex + 1 == capacity) {
            System.out.println("Heap Overflow!");
            return;
        }

        lastIndex++;
        heapArr[lastIndex] = data;

        heapifyUp(lastIndex);

        System.out.println(data + " Data inserted in Heap.");
    }

    void display() {
        if (lastIndex == -1) {
            System.out.println("Heap Underflow!");
            return;
        }

        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(6);

        heap.insertNode(20);
        heap.insertNode(5);
        heap.insertNode(30);
        heap.insertNode(50);
        heap.insertNode(40);
        heap.insertNode(1);

        heap.display();
    }
}
