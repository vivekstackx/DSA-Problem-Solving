class Solution {
   private int heapSize; 

    private void swap(int[] arr , int a , int b){
          int temp = arr[a]; 
          arr[a] = arr[b]; 
          arr[b] = temp;      
    }

    private void heapify(int[] arr , int parent){
       
         while(true){
             int largest = parent; 

             int leftChild = 2 * parent + 1; 
             int rightChild = 2 * parent + 2; 

             if(leftChild < heapSize && arr[leftChild] > arr[largest]){
                largest = leftChild;
             }

             if(rightChild < heapSize && arr[rightChild] > arr[largest]){
                largest = rightChild; 
             }

             if(largest == parent) break;

             swap(arr , parent , largest); 
             parent = largest; // move to downward
         }
    }

    private void deleteNode(int[] arr){
      
        swap(arr , 0 , heapSize - 1); 
        heapSize--; 

        heapify(arr , 0); 

    }


    public int kthSmallest(int[][] matrix, int k) {
        
        int totalBox = 0; 

        for(int i = 0; i < matrix.length; i++){
            totalBox = totalBox + matrix[i].length;
        }

        int[] arr = new int[totalBox]; 
        int index = 0; 

        // copy data from matrix to 1 D array 
        for(int i = 0; i < matrix.length; i++){
            
            for(int j = 0; j < matrix[i].length; j++){
                
                  arr[index] = matrix[i][j];
                  index++; 
            }
        }
        
        // sort the array using heap Sort 
        // convert to max - heap 
        int nonLeaf = arr.length / 2  - 1; 
        heapSize = arr.length; 

        for(int i = nonLeaf; i >= 0; i--){

             heapify(arr , i); 
        }

        for(int i = 1; i < arr.length; i++){

            deleteNode(arr);
        }

        return arr[k - 1];

    }
}
