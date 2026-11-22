class Solution {
    
    private void helper(int[] arr , int index){
       
          if(index == arr.length) return;
          
          System.out.print(arr[index] + " ");
          
          helper(arr , index + 1);
    }
    
    public void arrayTraversal(int[] arr) {
        
         helper(arr , 0);
    }
}
