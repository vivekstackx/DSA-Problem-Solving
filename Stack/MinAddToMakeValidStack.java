import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {

           Stack<Character> stack = new Stack<>();
            int r = 0;

         for(char ch : s.toCharArray()){
            // opening bracket
             if(ch == '('){
               stack.push(ch);
             }
             // closing bracket
             else if(ch == ')'){
                 if(stack.isEmpty()){
                    r++;
                 }
                 else {
                     stack.pop();
                 }
             }
         }
         return stack.size() + r;
    }
}
