class Solution {

    // merge two list
    private void merge(int[] arr , int ls , int le , int rs , int re, int[] temp){
       
        int index = 0;

        int start = ls;
        int end = re;

        while(ls <= le && rs <= re){

         if(arr[ls] <= arr[rs]){
             temp[index] = arr[ls];
             ls++; 
             index++;
           }
          else{
            temp[index] = arr[rs];
            rs++;
            index++; 
          }
      }

      if(ls > le){
          
          // trasfer second list data into temp array
          while(rs <= re){
             temp[index] = arr[rs];
             rs++; 
             index++;
          }
      }
      else{
         
         // transfer first list data into temp array
           while(ls  <= le){
             temp[index] = arr[ls];
             ls++;
             index++; 
           }
      }

      index = 0; 

      while(start <= end){
         arr[start] = temp[index];
         start++; 
         index++; 
      }

          
    }

    private void mergeSort(int[] arr , int start , int end , int[] temp){
      
          if(start == end) return; 

          int mid = start + (end - start) / 2; 
          
          // left portion
          mergeSort(arr , start , mid , temp); 
          // right portion
          mergeSort(arr , mid + 1 , end , temp);
          
          // merge two list (left portion list and right portion list)
          merge(arr , start , mid , mid + 1 , end , temp); 
                    
    }

    public int[] sortArray(int[] nums) {
        
        int[] temp  = new int[nums.length]; 

        mergeSort(nums , 0 , nums.length - 1 , temp);

        return nums;
    }
}
