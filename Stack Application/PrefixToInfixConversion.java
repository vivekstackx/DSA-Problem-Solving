import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    // Check whether current symbol is an operator
    private boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' ||
               symbol == '*' || symbol == '/' ||
               symbol == '^';
    }

    // Convert prefix expression to infix expression
    String prefixToInfix(String prefix) {

        // Stack stores intermediate infix expressions
        Deque<String> stack = new ArrayDeque<>();

        // Traverse each symbol of postfix expression from reverse order
        for (int i = prefix.length() - 1; i >= 0; i--) {
              
              char symbol = prefix.charAt(i);

            // If current symbol is an operator
            if (isOperator(symbol)) {

                // First popped operand becomes left operand
                String first = stack.pop();

                // Second popped operand becomes right operand
                String second = stack.pop();

                // Build a new infix expression and push back to stack
                switch (symbol) {

                    case '+':
                        stack.push("(" + first + "+" + second + ")");
                        break;

                    case '-':
                        stack.push("(" + first + "-" + second + ")");
                        break;

                    case '*':
                        stack.push("(" + first + "*" + second + ")");
                        break;

                    case '/':
                        stack.push("(" + first + "/" + second + ")");
                        break;

                    case '^':
                        stack.push("(" + first + "^" + second + ")");
                        break;
                }
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

public class PrefixToInfixConversion{

    public static void main(String[] args) {

        // Sample prefix expression
        String prefix = "+AB";

        // Convert prefix to infix
        String infix = new Solution().prefixToInfix(prefix);

        // Print final infix expression
        System.out.println(infix);
    }
}
