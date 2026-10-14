class Solution {
    private int heapSize;

    private void swap(int[] nums , int child , int parent){
        int temp = nums[child];
        nums[child] = nums[parent];
        nums[parent] = temp; 
    }
    private void heapify(int[] nums, int parent){

        while(true){
            int largest = parent;
            int leftChild = 2 * parent + 1; 
            int rightChild = 2 * parent + 2;

            if(leftChild < heapSize && nums[leftChild] > nums[largest]){
                largest = leftChild;
            }

            if(rightChild < heapSize && nums[rightChild] > nums[largest]){
                largest = rightChild;
            }

            if(largest == parent) break;
            swap(nums , largest , parent); 
            parent = largest; // move to downward 
        }
    }

    private int deleteNode(int[] nums){
         int largest = nums[0]; 

         nums[0] = nums[heapSize - 1];

         heapSize--;

         heapify(nums , 0);

         return largest; 
    }

    public int findKthLargest(int[] nums, int k) {
         
         heapSize = nums.length; 

        // convert into max-heap
        int nonLeaf = (heapSize / 2) - 1;

        for(int i = nonLeaf; i >= 0; i--){
            heapify(nums , i); 
        }

        // delete data K times from max-heap for Kth largest 
        int KthLargest = Integer.MIN_VALUE;

        for(int i = 1; i <= k; i++){
           KthLargest = deleteNode(nums); 
        }

        return KthLargest;

    }
}
