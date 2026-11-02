class MedianFinder {
   private PriorityQueue<Integer> maxHeap; 
   private PriorityQueue<Integer> minHeap;
   
    public MedianFinder() {

       maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
       minHeap = new PriorityQueue<>();
    }
    
    private void balance(){
       
        if(minHeap.size() + 2 == maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }

        if(maxHeap.size() + 2 == minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public void addNum(int num) {
        
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }

        if(num < maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }

        balance();
    }
    
    public double findMedian() {
        
          if(maxHeap.isEmpty()) return 0; 
          
           // equal
          if(maxHeap.size() == minHeap.size()) return (double)(maxHeap.peek() + minHeap.peek()) / 2; 
          
          // left > right 
         else if(maxHeap.size() - 1 == minHeap.size()) return maxHeap.peek(); 

          // right > left 
         else return minHeap.peek(); 

    }
}
