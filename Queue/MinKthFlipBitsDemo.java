class Solution{
     
     // function to get the minimum number of k Consecutive Flip bits
      int minKthFlipBits(int[] arr, int k) {

          int n = arr.length;
          int flipCount = 0;

          for(int i = 0; i < n; i++){
             
               if(arr[i] == 0){ 
                  
                 int windowEnd = i + k;

                 if(windowEnd > n){
                   return -1;
                 }
                  else{
                     for(int j = i; j < i + k; j++){
                        if(arr[j] == 0){
                           arr[j] = 1;
                        }
                        else{
                           arr[j] = 0;
                        }
                     }
                     flipCount++;
                  }
               }
          }
          return flipCount;
      }
}

class MinKthFlipBitsDemo{
    public static void main(String[] args){

        int[] arr = {0, 0, 1, 0, 0, 1, 1, 0, 1, 0};
        int k = 4;
        
        int flip = new Solution().minKthFlipBits(arr, k);
        System.out.println("flip is : "+ flip);
    }
}
