import java.util.Deque;
import java.util.ArrayDeque;

class Solution{

// function to check weather the symbol is operator or not 
private boolean isOperator(char symbol){
  return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '^';
}
  // function to convert prefix  to postfix
  String prefixToPostfix(String prefix){
     
      Deque<String> stack = new ArrayDeque<>();
         
     for(int i = prefix.length() - 1; i >= 0; i--){
        
          char symbol = prefix.charAt(i); 

         if(isOperator(symbol)){
           
            String first = stack.pop();
            String second = stack.pop();

             String exp = first + second + symbol;
             stack.push(exp);

         }
         else{
           stack.push(String.valueOf(symbol));
         }
     }
     return stack.pop(); // final postfix
  }
}

public class PrefixToPostfixConversion {
    public static void main(String[] args) {
      String prefix = "-+a/*bcde";

      String postfix = new Solution().prefixToPostfix(prefix);
      System.out.println(postfix);
    }
}
