/*
Time complexity : 

push() — O(log n)
pop() — O(log n)
peek() — O(1)
getSize() / isEmpty() — O(1)

*/

class Pair {
    int data, priority;

    Pair(int data, int priority) {
        this.data = data; 
        this.priority = priority; 
    }
}

class MaxPriorityQueue {
    private int heapSize; 
    private Pair[] heapArr;

    MaxPriorityQueue(int queueSize) {
        this.heapSize = 0; 
        heapArr = new Pair[queueSize];
    }

    private void swap(int child, int parent) {
        Pair temp = heapArr[parent]; 
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
    }

    private void stepUp(int child) {
        while (child > 0) {
            int parent = (child - 1) / 2; 

            if (heapArr[parent].priority < heapArr[child].priority) {
                swap(child, parent); 
                child = parent; // move upward
            } else {
                break;
            }
        }
    }

    // Push the data in queue based on the priority
    void push(int data, int priority) {
        if (heapSize == heapArr.length) {
            System.out.println("Queue overflow !");
            return;
        }

        heapArr[heapSize] = new Pair(data, priority); 
        stepUp(heapSize);
        heapSize++;

        System.out.println(data + " Data pushed in queue.");
    }

    // Check queue is empty or not 
    boolean isEmpty() {
        return heapSize == 0; 
    }

    private void heapify(int parent) {
        while (true) {
            int max = parent;

            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2; 

            if (leftChild < heapSize && heapArr[leftChild].priority > heapArr[max].priority) {
                max = leftChild;
            }

            if (rightChild < heapSize && heapArr[rightChild].priority > heapArr[max].priority) {
                max = rightChild;
            }

            if (max == parent) break;

            swap(max, parent);
            parent = max; // move to stepdown
        }
    }

    // Pop the data from queue based on the priority 
    int pop() {
        if (isEmpty()) {
            System.out.println("Queue underflow !");
            return -1;
        }

        int deletedData = heapArr[0].data;

        heapArr[0] = heapArr[heapSize - 1]; 
        heapSize--;

        heapify(0);

        return deletedData;
    }

    // get the peek data form queue based on the priority 
      int peek(){
        if(isEmpty()){
           System.out.println("queue underflow !");
           return -1; 
        }
        return heapArr[0].data;
      }

    // Function to get the size of the priority queue 
    int getSize() {
        return heapSize; 
    }
}

public class Main {
    public static void main(String[] args) {
        int queueSize = 10; 

        MaxPriorityQueue pq = new MaxPriorityQueue(queueSize);

        pq.push(10, 3);
        pq.push(4, 6);
        pq.push(12, 9);
        pq.push(17, 1);
        pq.push(8, 2);

        System.out.println("Popped: " + pq.pop());
        System.out.println("Popped: " + pq.pop());
        System.out.println("Popped: " + pq.pop());
        System.out.println("Popped: " + pq.pop());
        System.out.println("Popped: " + pq.pop());
        System.out.println("Popped: " + pq.pop());
    }
}
