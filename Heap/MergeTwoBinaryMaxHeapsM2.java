
public class Solution {
    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

         for(int data : arr1){
             maxHeap.offer(data);
         }

         for(int data : arr2){
             maxHeap.offer(data);
         }

         ArrayList<Integer> ans = new ArrayList<>(); 

         while(!maxHeap.isEmpty()){
             ans.add(maxHeap.poll());
         }

        return ans;
    }
}
