class Solution {
    
    private int getMin(int[] arr , int index){
       
          if(index == arr.length) return Integer.MAX_VALUE;
          
          return Math.min(arr[index] , getMin(arr , index + 1)); 
    }
    
    public int findMin(int[] arr) {
       
       return getMin(arr , 0);        
         
    }
}
