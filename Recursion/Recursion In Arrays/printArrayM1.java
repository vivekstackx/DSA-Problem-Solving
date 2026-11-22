class Solution {
    
    private void helper(int[] arr , int index){
       
          if(index == -1) return;
          
          helper(arr , index - 1); 
          
          System.out.print(arr[index] + " ");
    }
    
    public void arrayTraversal(int[] arr) {
        
         helper(arr , arr.length - 1);
    }
}
