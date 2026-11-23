class Solution {
    
    private int binarySearch(int[] arr , int target , int start , int end){
       
          if(start > end) return -1; 
          
         int mid = start + (end - start) / 2;
          
          if(arr[mid] == target){
              return mid;
          }
          else if(target < arr[mid]){
              return binarySearch(arr , target , start , mid - 1);
          }
          else return binarySearch(arr , target , mid + 1 , end); 
    }
    
    public int search(int arr[], int x) {

        return binarySearch(arr , x , 0 , arr.length - 1); 
    }
}
