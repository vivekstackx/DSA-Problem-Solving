import java.util.ArrayDeque;
import java.util.Deque;

class Solution{


      public int largestRectangleArea(int[] heights) {
        
          Deque<Integer> stack = new ArrayDeque<>();
          
          int n = heights.length;
          int maxArea = 0;
          
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
}

public class LargestRectangleInHistogram2 {
    public static void main(String[] args) {
      
       int[] histogram = {2, 3, 4, 2, 6, 5, 4, 5, 3};
         
       int maxArea = new Solution().largestRectangleArea(histogram);
       System.out.println(maxArea);
    }
}
