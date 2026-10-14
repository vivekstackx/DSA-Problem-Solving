class Solution {
  private int heapSize;

    private void swap(int[] nums , int child , int parent){
          int temp = nums[child]; 
          nums[child] = nums[parent];
          nums[parent] = temp; 
    }

    private void heapify(int[] nums , int parent){

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

    private void deleteNode(int[] nums){
      
      swap(nums , 0 , heapSize - 1); 

      heapSize--;

      heapify(nums , 0); 
    }

    public int findKthLargest(int[] nums, int k) {
        
         heapSize = nums.length;
        // convert into max - heap 
         int nonLeaf = (nums.length / 2) - 1;

         for(int i = nonLeaf; i >= 0; i--){
            heapify(nums , i); 
         }

         // delete each data from max - heap 
         for(int i = 1; i < nums.length; i++){
             deleteNode(nums); 
         }
       
        return nums[nums.length - k]; 

    }
}
