// this code is not efficient

class MedianFinder {
   private ArrayList<Integer> list;
   private double currentMedian; 
   private int heapSize; 

    public MedianFinder() {
        list = new ArrayList<>(); 
    }
   
    private void swap(int a , int b){
        
        int temp = list.get(a); 
        list.set(a , list.get(b)); 
        list.set(b , temp);
    }

    private void heapify(int parent){
      
         while(true){
             
             int largest = parent;
             int leftChild = 2 * parent + 1; 
             int rightChild = 2 * parent + 2; 

             if(leftChild < heapSize && list.get(leftChild) > list.get(largest)){
                largest = leftChild;
             }

             if(rightChild < heapSize && list.get(rightChild) > list.get(largest)){
                largest = rightChild;
             }

             if(largest == parent) break; 

             swap(parent , largest); 
             parent = largest; // move to downward
         
         }
    }

    private void deleteNode(){
      
        swap(0 , heapSize - 1); 
        heapSize--; 

        heapify(0);
    }

    private void heapSort(ArrayList<Integer> list){
          heapSize = list.size(); 

        // convert list into max-heap 
          int nonLeaf = heapSize / 2 - 1; 
          
          for(int i = nonLeaf; i >= 0; i--){
             heapify(i);
          }

        // delete every node from max-heap 
          for(int i = 1; i <= list.size(); i++){
              deleteNode();
          }
    }
    
    public void addNum(int num) {
       
         list.add(num); 
         
         // sort the list using heap sort 
          heapSort(list); 

          int size = list.size(); 

          // even size 
          if(size % 2 == 0){
             
             int b = size / 2; 
             int a = b - 1; 
             
             currentMedian = (double)(list.get(a) + list.get(b)) / 2; 
          }
          else{  
             currentMedian = list.get(size / 2);

          }
    }
     
    public double findMedian() {
        return currentMedian;
    }
}
