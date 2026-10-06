import java.util.*;

class Heap {
   private int[] heapArr;
   private int heapSize;
       
        Heap(int[] heapArr , int heapSize){
            this.heapArr = heapArr;
            this.heapSize = heapSize;
        }
    
      private void swap(int parent , int child){
         int temp = heapArr[parent];
         heapArr[parent] = heapArr[child];
         heapArr[child] = temp;
      }

      private void heapifyDown(int parent){

          int leftChild = 2 * parent + 1;
          int rightChild = 2 * parent + 2;
           
           // leaf
          if(leftChild > heapSize && rightChild > heapSize){
             return; 
          }
          // both 
          if(leftChild < heapSize && rightChild < heapSize){
             
               if(heapArr[leftChild] > heapArr[rightChild]){
                   if(heapArr[parent] < heapArr[leftChild]){
                      swap(parent , leftChild);
                      heapifyDown(leftChild);
                   }
                   return;
               }
               else{
                   if(heapArr[parent] < heapArr[rightChild]){
                     swap(parent , rightChild);
                     heapifyDown(rightChild);
                   }
                   return;
               }
          }

          // one left child 
            if(heapArr[parent] < heapArr[leftChild]){
              swap(parent , leftChild);
            }
          
      }

     // delete the node from max heap 
        void deleteNode(){
            if(heapSize == 0) {
               System.out.println("Heap underflow !");
               return;
            }
            int temp = heapArr[0];

            heapArr[0] = heapArr[heapSize - 1];
            heapSize--;

            heapifyDown(0);

            System.out.println(temp + " Data deleted from Heap.");

        }


        void display(){
           if(heapSize == 0){
             System.out.println("Heap underflow !");
             return;
           }

           for(int i = 0; i < heapSize; i++){
              System.out.print(heapArr[i] + " "); 
           }

           System.out.println();
        }
}



public class Main {
    public static void main(String[] args) {
        
        int[] heapArr = {30, 18, 15, 14 , 17 , 13 , 10};
         
        int heapSize = 7; 

        Heap heap = new Heap(heapArr , heapSize); 

       heap.deleteNode(); 
       heap.deleteNode();
       heap.deleteNode();
       heap.deleteNode();
       heap.deleteNode();
       heap.deleteNode();
       heap.deleteNode();
       heap.deleteNode();

       heap.display();
    }
}
