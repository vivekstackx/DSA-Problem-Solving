import java.util.Deque;
import java.util.ArrayDeque;

class Solution{

// function to check weather the symbol is operator or not 
private boolean isOperator(char symbol){
  return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '^';
}
  // function to convert postfix to prefix 
  String postfixToPrefix(String postfix){
     
      Deque<String> stack = new ArrayDeque<>();

     for(char symbol : postfix.toCharArray()){
        
         if(isOperator(symbol)){
           
            String first = stack.pop();
            String second = stack.pop();

             String exp = symbol + second + first;
             stack.push(exp);

         }
         else{
           stack.push(String.valueOf(symbol));
         }
     }
     return stack.pop(); // final prefix
  }
}

public class PostfixToPrefix {
    public static void main(String[] args) {
      String postfix = "ABC*D/+E-";

      String prefix = new Solution().postfixToPrefix(postfix);
      System.out.println(prefix);
    }
}
