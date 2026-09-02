class Solution {

     private int index;

     private void helper(List<Integer> arr, int lowerBound, int upperBound) {

         if (index == arr.size()) return;

         int value = arr.get(index);

         if (!(lowerBound < value && value < upperBound)) return;

         index++;

         // Left subtree
         helper(arr, lowerBound, value);

         // Right subtree
         helper(arr, value, upperBound);
     }

     public boolean canRepresentBST(List<Integer> arr) {

         index = 0;

         int lowerBound = Integer.MIN_VALUE;
         int upperBound = Integer.MAX_VALUE;

         helper(arr, lowerBound, upperBound);

         return index == arr.size();
     }
 }
