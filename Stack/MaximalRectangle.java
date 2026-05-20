import java.util.ArrayDeque;
import java.util.Deque;

class Solution{
  
   // function to get the largest rectangle area in single paas
    private int largestRectangleArea(int[] heights) {
      
        int maxArea = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
       
       // get largest rectangle
        for(int i = 0; i < n; i++){
             
             int currentHeight = heights[i];
             
             while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                  
                  int nextSmallest = i;
                  int height = heights[stack.pop()];
                  int previousSmallest = -1;

                  if(!stack.isEmpty()){
                    previousSmallest = stack.peek();
                  }
                  int width = (nextSmallest - previousSmallest) - 1;
                  int area = height * width;
                  maxArea = Math.max(area , maxArea);
             }
             stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int nextSmallest = n;
            int previousSmallest = -1;

            if(!stack.isEmpty()){
                previousSmallest = stack.peek();
            }

            int width = (nextSmallest - previousSmallest) - 1;
            int area = height * width;
            maxArea = Math.max(area , maxArea);
        }

        return maxArea;

    }
    // function to get the maximal rectangle in matrix
      public int maximalRectangle(char[][] matrix) {
            
            int maxArea = 0;
            
           int row = matrix.length;
           int column = matrix[0].length;
           
           int[] heights = new int[column];
          
           // Traverse the matrix 
           for(int i = 0; i < row; i++){
              for(int j = 0; j < column; j++){
                 
                 if(matrix[i][j] == '1'){
                   heights[j]++;
                 }
                 else {
                   heights[j] = 0;
                 }
                 
              }
                int area = largestRectangleArea(heights);
                maxArea = Math.max(area , maxArea);
                
           }
           return maxArea;
    }
}



public class MaximalRectangle {
    public static void main(String[] args) {
       
       char[][] matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'}, 
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
};
       
       int maxArea = new Solution().maximalRectangle(matrix);
       System.out.println(maxArea);
    }
}
