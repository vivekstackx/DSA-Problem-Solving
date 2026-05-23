class Solution{
  
   int celebrity(int[][] matrix){
       
        if(matrix == null || matrix.length == 0) {
           return -1;
       }  
       int n = matrix.length;
       
       boolean isCelebrityKnowOther = false;
       
       for(int i = 0; i < n; i++){
           isCelebrityKnowOther = false;
            for(int j = 0; j < n; j++){
               if(i == j){
                 continue;
               }
               if(matrix[i][j] == 1){
                  isCelebrityKnowOther = true;
                  break;
               }
            }
            if(!isCelebrityKnowOther){
                boolean otherKnowCelebrity = true;
               for(int k = 0; k < n; k++){
                  if(k == i){
                    continue;
                  }
                  if(matrix[k][i] == 0){
                    otherKnowCelebrity = false;
                    break;
                  }
               }
               if(otherKnowCelebrity){
                 return i;
               }
            }
       }
       return -1;
   }
}

public class GetCelebrity {
    public static void main(String[] args) {
    int[][] matrix = { 
      {0,1,0,1,1},
      {0,0,0,1,1},
      {0,1,0,1,0},
      {0,0,0,0,0},
      {1,0,1,1,0}
      };
      
       int celebrity = new Solution().celebrity(matrix);
       System.out.println(celebrity);
    
    }
}
