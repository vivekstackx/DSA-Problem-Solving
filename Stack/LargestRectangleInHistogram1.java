import java.util.Stack;

class Solution{
    // function to get the previous smallest element
    private int[] getPreviousSmallest(int[] heights){
       int n = heights.length;
       
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
           
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
               ans[stack.peek()] = i;
               stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
           ans[stack.pop()] = -1;
        }
        return ans; 
     }
     // function to get the next smallest element
    private int[] getNextSmallest(int[] heights){
        int n = heights.length;
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
          
           while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
             ans[stack.peek()] = i;
             stack.pop();
           }
           stack.push(i);
        }
        while(!stack.isEmpty()){
          ans[stack.pop()] = n;
        }
        return ans;
     }
     // function to get the largest area of Histogram
      public int largestRectangleArea(int[] heights) {
        
          int n = heights.length;
          
         int maxArea = 0;
         
        int[] rightSmallest = getNextSmallest(heights);
        int[] previousSmallest = getPreviousSmallest(heights);
        
        for(int i = 0; i < n; i++){
          
           int height = heights[i];
           int width = (rightSmallest[i] - previousSmallest[i]) - 1;
           int area = height * width;
           
           if(area > maxArea){
             maxArea = area;
           }
        }
        return maxArea;
    }
}


public class LargestRectangleInHistogram1 {
    public static void main(String[] args) {
       int[] heights = {2, 3, 4, 2, 6, 5, 4, 5, 3};
       
       int maxArea = new Solution().largestRectangleArea(heights);
       
       System.out.println(maxArea);
    }
}
