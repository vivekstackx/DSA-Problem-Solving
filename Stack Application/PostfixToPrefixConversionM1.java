import java.util.ArrayDeque;
import java.util.Deque;

class Solution{
 /*
  Logic : convert postfix -> infix then convert infix to prefix
 */
 // check current symbol operator ya parenthesis hai ya nahi
    private boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' ||
                symbol == '*' || symbol == '/' ||
                symbol == '^' || symbol == '(' ||
                symbol == ')';
    }

    // operator precedence return karta hai
    // bigger number = higher precedence
    private int checkPrecedence(char symbol) {

        if (symbol == '^') {
            return 3;
        } else if (symbol == '*' || symbol == '/') {
            return 2;
        } else if (symbol == '+' || symbol == '-') {
            return 1;
        } else {
            return 0; // for '(' and ')'
        }
    }

    // check operator right associative hai ya nahi
    // only '^' is right associative
    private boolean isRightAssociative(char symbol) {

        /*
         * ^  => right to left associativity
         * +, -, *, / => left to right associativity
         */
        return symbol == '^';
    }

// function to reverse the string
private void reverseString(StringBuilder str) {
    int i = 0;
    int j = str.length() - 1;

    while (i < j) {
        swap(str, i, j);
        i++;
        j--;
    }
}

// function to swap the characters
private void swap(StringBuilder str, int i, int j) {

    char first = str.charAt(i);
    char second = str.charAt(j);

    str.setCharAt(i, second);
    str.setCharAt(j, first);
  }



//------------------------------------------------------------
    // Convert postfix expression to infix expression
    private String postfixToInfix(String postfix) {

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
                switch (symbol) {

                    case '+':
                        stack.push("(" + second + "+" + first + ")");
                        break;

                    case '-':
                        stack.push("(" + second + "-" + first + ")");
                        break;

                    case '*':
                        stack.push("(" + second + "*" + first + ")");
                        break;

                    case '/':
                        stack.push("(" + second + "/" + first + ")");
                        break;

                    case '^':
                        stack.push("(" + second + "^" + first + ")");
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

//----------------------------------------------------------------------

 
    // function to convert infix expression into prefix expression
   private String infixToPrefix(String expression) {

        // stack used for operators and parentheses
        Deque<Character> stack = new ArrayDeque<>();

        // stores final prefix expression
        StringBuilder prefix = new StringBuilder();

        int n = expression.length();

        // traverse each symbol of infix expression from reverse order
        for (int i = n - 1; i >= 0; i--) {
               
               char symbol = expression.charAt(i);
            // if current symbol is operator or parenthesis
            if (isOperator(symbol)) {

                // closing parenthesis always push into stack
                if (symbol == ')') {

                    stack.push(symbol);
 
                }
                // opening parenthesis found
                else if (symbol == '(') {

                    // pop everything until closing parenthesis is found
                    while (stack.peek() != ')') {
                        prefix.append(stack.pop());
                    }

                    // remove closing parenthesis from stack
                    stack.pop();
                }

                // current symbol is operator (+,-,*,/,^)
                else {

                    /*
                     * POP CONDITIONS:
                     *
                     * 1. Stack top precedence > current operator precedence
                     * 2. Same precedence and current operator is Right associative
                     * 3. when opening parentheses are current operator then pop operator till closing parentheses
                     
                     * PUSH CONDITIONS:
                     * 1. Stack empty
                     * 2. Stack top is ')'
                     * 3. Stack top precedence < current operator precedence
                     * 4. Same precedence and current operator is Left associative (^)
                     */

                    while (!stack.isEmpty()
                            && stack.peek() != ')'
                            && (
                                checkPrecedence(stack.peek()) > checkPrecedence(symbol)
                                ||
                                (
                                    checkPrecedence(stack.peek()) == checkPrecedence(symbol)
                                    && isRightAssociative(symbol)
                                )
                            )) {

                        // move operator from stack to prefix
                        prefix.append(stack.pop());
                    }

                    // finally push current operator into stack
                    stack.push(symbol);
                }
            }

            // operand directly goes to prefix
            else {
                prefix.append(symbol);
            }
        }

        // pop all remaining operators from stack
        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        // reverse the expression
        reverseString(prefix);

        return prefix.toString();
         
    }
   



  //  function to convert postfix to prefix 
   String postfixToPrefix(String postfix){

        String infix = postfixToInfix(postfix);
        String prefix = infixToPrefix(infix); 
        
        return prefix;
   }
}

public class PostfixToPrefixConversionM1{
     public static void main(String[] args){
        
        String postfix = "AB+";

        String prefix = new Solution().postfixToPrefix(postfix);
 
        System.out.println("Prefix is : " + prefix);
     }
}
