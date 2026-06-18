import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    // Check whether current symbol is an operator
    private boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' ||
               symbol == '*' || symbol == '/' ||
               symbol == '^';
    }

    // Convert postfix expression to infix expression
    String postfixToInfix(String postfix) {

        // Stack stores intermediate infix expressions
        Deque<String> stack = new ArrayDeque<>();

        // Traverse each symbol of postfix expression
        for (char symbol : postfix.toCharArray()) {

            // If current symbol is an operator
            if (isOperator(symbol)) {

                // First popped operand becomes right operand
                String first = stack.pop();

                // Second popped operand becomes left operand
                String second = stack.pop();

                // Build a new infix expression and push back to stack
                   stack.push("(" + second + symbol + first + ")");
            }
            else {
                // Operand directly goes into stack
                stack.push(String.valueOf(symbol));
            }
        }

        // Final infix expression will be present at top of stack
        return stack.pop();
    }
}

public class PostfixToInfixConversion{

    public static void main(String[] args) {

        // Sample postfix expression
        String postfix = "ABC*D/+E-";

        // Convert postfix to infix
        String infix = new Solution().postfixToInfix(postfix);

        // Print final infix expression
        System.out.println(infix);
    }
}
