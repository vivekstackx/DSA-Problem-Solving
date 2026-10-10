import java.util.*;

class Heap{


  private void swap(int[] heapArr , int child , int parent){
     
     int temp = heapArr[parent];
     heapArr[parent] = heapArr[child];
     heapArr[child] = temp; 

  }
  // convert max - heap using heapify approch 
   private void heapify(int[] heapArr , int parent){
          int heapSize = heapArr.length;
    
        while(true){

            int max = parent;

            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            
            if(leftChild < heapSize && heapArr[leftChild] > heapArr[max]){
               max = leftChild;
            }

            if(rightChild < heapSize && heapArr[rightChild] > heapArr[max]){
               max = rightChild;
            }

            if(max == parent) break;

            swap(heapArr , max , parent); 
            parent = max; // move to step down 


        }
   }

   void convertMaxHeap(int[] heapArr){
     
      int nonLeaf = (heapArr.length / 2) - 1;

      for(int i = nonLeaf; i >= 0; i--){
          
            heapify(heapArr , i);
      }
   }

   void display(int[] heapArr){
       
       for(int i = 0; i < heapArr.length; i++){
          System.out.print(heapArr[i] + " ");
       }

       System.out.println();
   }
}




public class Main {
    public static void main(String[] args) {
      
       Heap heap = new Heap(); 

        int[] heapArr = {3, 9, 5, 7, 10, 6, 19, 50, 3, 4, 1}; 

       heap.display(heapArr); 

       heap.convertMaxHeap(heapArr); 

       heap.display(heapArr);
    }
}
