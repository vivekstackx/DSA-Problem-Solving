import java.util.*;

class Heap{
   


   private void swap(int[] heapArr , int parent , int child){

        int temp = heapArr[parent]; 
        heapArr[parent] = heapArr[child];
        heapArr[child] = temp;
   }

   private void stepUp(int[] heapArr , int child){
     
        while(child > 0){
            
           int parent = (child - 1) / 2;

           if(heapArr[parent] < heapArr[child]){
              swap(heapArr , parent , child); 
              child = parent;
           }
           else break;
        }
   }
   // convert the max heap using step-up approch
   void convertMaxHeap(int[] heapArr){
     
      for(int i = 1; i < heapArr.length; i++){
          stepUp(heapArr , i); 
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
