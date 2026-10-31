class Solution {
  private int heapSize; 

    private void swap(int[] arr , int a , int b){

           int temp = arr[a];
           arr[a] = arr[b]; 
           arr[b] = temp;
    }

    private void heapify(int[] arr , int parent){
       
        while(true){
            
            int smallest = parent; 

            int leftChild = 2 * parent + 1; 
            int rightChild = 2 * parent + 2; 

            if(leftChild < heapSize && arr[leftChild] < arr[smallest]){
                smallest = leftChild;
            }

            if(rightChild < heapSize && arr[rightChild] < arr[smallest]){
                smallest = rightChild; 
            }

            if(parent == smallest) break;

            swap(arr , parent , smallest); 

            parent = smallest; // move to downward
        }
    }

    private int deleteNode(int[] arr){

         int deletedData = arr[0]; 

         arr[0] = arr[heapSize - 1]; 
         heapSize--; 

         heapify(arr , 0);

         return deletedData;
    }

    public int kthSmallest(int[][] matrix, int k) {
        
        int totalBox = 0; 

        for(int i = 0; i < matrix.length; i++){
            totalBox = totalBox + matrix[i].length;
        }

        int[] arr = new int[totalBox]; 
        heapSize = arr.length; 
        
        int index = 0; 

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                arr[index] = matrix[i][j]; 
                index++;
            }
        }

        // convert into min heap 
        int nonLeaf = arr.length / 2 - 1; 

        for(int i = nonLeaf; i >= 0; i--){
            heapify(arr , i);
        }
        
        int kth  = 0; 

        while(k > 0){
            kth = deleteNode(arr); 
            k--;
        }

        return kth; 
       

    }
}
