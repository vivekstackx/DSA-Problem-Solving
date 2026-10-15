class MinHeap{
   private int[] heap; 
   private int heapSize;  

      MinHeap(int size){
         this.heap = new int[size]; 
         this.heapSize = -1;
      }

      // swap 
      private void swap(int child , int parent){

         int temp = heap[child]; 
         heap[child] = heap[parent]; 
         heap[parent] = temp;
      }

      // step up 
      private void stepUp(int child){
          
           while(child > 0){
              int parent = (child - 1) / 2; 

              if(heap[parent] > heap[child]){
                 swap(parent , child);
                 child = parent; // move to upward
              }
              else break; 
           }
      }

      // heapify
      private void heapify(int parent){
         
           while(true){

              int smallest = parent; 
              int leftChild = 2 * parent + 1; 
              int rightChild = 2 * parent + 2; 

              if(leftChild <= heapSize && heap[leftChild] < heap[smallest]){
                smallest = leftChild;
              }

              if(rightChild <= heapSize && heap[rightChild] < heap[smallest]){
                smallest = rightChild;
              }

              if(smallest == parent) break; 

              swap(smallest , parent); 
              parent = smallest; // move to downward
           }
      }
      // delete data from max-heap
      int deleteNode(){

         if(heapSize == -1){
            System.out.println("underflow !"); 
            return -1;
         }
         int deletedData = heap[0]; 
         swap(0 , heapSize);
         heapSize--;
         
         heapify(0);

         return deletedData; 
      }      
     

      // insert data into max-heap 
      void insert(int data){
          if(heapSize + 1 == heap.length){
             System.out.println("overflow !");
             return; 
          }
          heapSize++; 
          heap[heapSize] = data; 

          stepUp(heapSize);

      }

      // check heap is empty or not 
      boolean isEmpty(){
         return heapSize == -1;
      }
      // get peek data from max-heap 
      int peek(){
         return isEmpty() ? -1 : heap[0];
      }
}



class Solution {
    public int findKthLargest(int[] nums, int k) {

        // make k group for kth largest 
         MinHeap heapGroup =  new MinHeap(k); 

         for(int i = 0; i < k; i++){
              heapGroup.insert(nums[i]);
         }

         for(int i = k; i < nums.length; i++){

             if(nums[i] > heapGroup.peek()){
                 heapGroup.deleteNode();
                 heapGroup.insert(nums[i]);
             }
         }

         return heapGroup.peek();
    }
}
