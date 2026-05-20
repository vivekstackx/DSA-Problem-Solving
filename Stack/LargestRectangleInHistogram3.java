import java.util.ArrayDeque;
import java.util.Deque;

class Solution{
  /*
     ye vala me maine ek trick lagaya h , mai for loop ko heights.length tak chala rha hun , 
     jab i = height.length ho jata h yani index ke bahar ho jata h i , to uas time mai height ko 0 pe set kar 
     deta hun , jisse fayada ye hota h ki jab for loop terminate ho jata h , to fir stack me fir v element kuchh 
     bach sakte h , to ham ek or loop yani while loop lagate h or sabhi element ko stack se ek ke karke pop karte h 
     or sabhi element ka area calcutate karte h , yani notice karne vali baat ye h ki ham yanha extra ek loop laga 
     rhe h yani ki while loop , but ye kaam without extra while loop ke v kaam ho sakta h , iaske lie maine trick use kiya h
     jab i == height.length tak jata h , to ham height 0 pe set karte h kyunki iasse for loop chalte time hi last time pe 
     stack se o sabhi jo data rah gya tha uan sabhi ka area calculate ho jati h , jisse hame extra while loop ki need nahi hoti h
  */
  public int largestRectangleArea(int[] heights) {
    
    Deque<Integer> stack = new ArrayDeque<>();
    int maxArea = 0;
    
    // Notice loop goes up to heights.length
    for (int i = 0; i <= heights.length; i++) {
        // Use 0 as a sentinel height at the very end to flush the stack
        int currentHeight = (i == heights.length) ? 0 : heights[i];
        
        while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int previousSmallest = stack.isEmpty() ? -1 : stack.peek();
            int width = i - previousSmallest - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
    
    return maxArea;
  }
}

public class LargestRectangleInHistogram3 {
    public static void main(String[] args) {
      
       int[] histogram = {2, 3, 4, 2, 6, 5, 4, 5, 3};
         
       int maxArea = new Solution().largestRectangleArea(histogram);
       System.out.println(maxArea);
    }
}
