import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution{
     // print bracket number
      List<Integer> printBracketNo(String str){
        
           Stack<Integer> stack = new Stack<>();
           List<Integer> ans = new ArrayList<>();
           
          int count = 0;
           for(char ch : str.toCharArray()){
                if(ch == '('){
                  count++;
                  stack.push(count);
                  ans.add(count);
                  
                }
                else if(ch == ')'){
                   ans.add(stack.pop());
                }
           }
           return ans;
      }
}

public class BracketNumber {
    public static void main(String[] args) {
       String str = "(aa(bdc))p(dc)";
       List<Integer> ans = new Solution().printBracketNo(str);
       System.out.println(ans);
    }
}
