

public class Solution {

    private static void swap(ArrayList<Integer> ans , int a , int b){
         int temp = ans.get(a); 
         ans.set(a , ans.get(b));
         ans.set(b , temp);
    }

    private static void heapify(ArrayList<Integer> ans , int parent){
      
       while(true){
           int largest = parent; 

           int leftChild = 2 * parent + 1;
           int rightChild = 2 * parent + 2; 

           if(leftChild < ans.size() && ans.get(leftChild) > ans.get(largest)){
               largest = leftChild;
           }

           if(rightChild < ans.size() && ans.get(rightChild) > ans.get(largest)){
               largest = rightChild;
           }

           if(parent == largest) break;

           swap(ans , parent , largest); 
           parent = largest; // move to downward
       }
    }

    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
       
        ArrayList<Integer> ans = new ArrayList<>();

        for(int data : arr1){
            ans.add(data);
        }

        for(int data : arr2){
            ans.add(data);
        }

        int nonLeaf = (ans.size() / 2) - 1;

        for(int i = nonLeaf; i >= 0; i--){
            heapify(ans , i);
        }

        return ans;
    }
}
