class Solution {
    private boolean isExit(int x , int y , List<Integer> list){
          for(int i = 0; i < list.size(); i++){
                if(list.get(i) >= x && list.get(i) <= y) return true; 
                if(list.get(i) > y) break;
         }
         return false;
    }

    private boolean isRange(int x , int y , List<List<Integer>> nums){
          for(int i = 0; i < nums.size(); i++){
              if(!isExit(x , y , nums.get(i))) return false;
          }
          return true;
    }

    public int[] smallestRange(List<List<Integer>> nums) {
         int total = 0; 
         for(int i = 0; i < nums.size(); i++){
              total = total + nums.get(i).size();
         }

         int[] arr = new int[total]; 
         int index = 0; 
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums.get(i).size(); j++){
                arr[index] = nums.get(i).get(j);
                index++;
            }
        }

         int min = 0; 
         int max = 0;
         int diff = Integer.MAX_VALUE; 

         
         for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                
                int x = 0; 
                int y = 0; 

                if(arr[i] < arr[j]){
                    x = arr[i];
                    y = arr[j];
                }
                else{
                    x = arr[j];
                    y = arr[i];
                }

                if(isRange(x, y , nums)){
                    if((y - x) < diff){
                        min = x;
                        max = y;
                        diff = y - x;
                    }
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}
