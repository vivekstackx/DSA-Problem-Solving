class Solution {
    
    private static int getMax(int[] arr , int index){
         
         if(index == arr.length) return Integer.MIN_VALUE;
         
         return Math.max(arr[index] , getMax(arr , index + 1)); 
    }
    public static int largest(int[] arr) {
        // code here
        return getMax(arr , 0);
    }
}
