// this code is efficient

class MedianFinder {
    
    // maxHeap stores the smaller half of the numbers (root is the largest of the small elements)
    private PriorityQueue<Integer> maxHeap; 
    
    // minHeap stores the larger half of the numbers (root is the smallest of the large elements)
    private PriorityQueue<Integer> minHeap;
   
    public MedianFinder() {
        // Initialize maxHeap with reverse order (descending)
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // Initialize minHeap with natural order (ascending)
        minHeap = new PriorityQueue<>();
    }
    
    // Helper method to balance both heaps so their size difference is at most 1
    private void balance() {
        // If maxHeap has 2 elements more than minHeap, move top element to minHeap
        if(minHeap.size() + 2 == maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }

        // If minHeap has 2 elements more than maxHeap, move top element to maxHeap
        if(maxHeap.size() + 2 == minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public void addNum(int num) {
        // If maxHeap is empty, directly add the first element
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }

        // Decide which heap the number belongs to based on the root of maxHeap
        if(num < maxHeap.peek()){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps after insertion
        balance();
    }
    
    public double findMedian() {
        // If no elements are present, return 0
        if(maxHeap.isEmpty()) return 0; 
         
        // Case 1: Total number of elements is even (both heaps are of equal size)
        if(maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2; 
        } 
        
        // Case 2: Total number of elements is odd, and maxHeap has one extra element
        else if(maxHeap.size() - 1 == minHeap.size()) {
            return maxHeap.peek(); 
        } 

        // Case 3: Total number of elements is odd, and minHeap has one extra element
        else {
            return minHeap.peek(); 
        }
    }
}
