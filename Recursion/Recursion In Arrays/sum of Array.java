class Solution {
    
    private int getSum(int[] arr , int index){
         
           if(index == arr.length) return 0; 
           
           return arr[index] + getSum(arr , index + 1); 
    }
    
    public int arraySum(int arr[]) {
      
        return getSum(arr , 0);
    }
}
