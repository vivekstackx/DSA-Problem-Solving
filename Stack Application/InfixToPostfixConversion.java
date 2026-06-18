import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

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

    // function to convert infix expression into postfix expression
    String infixToPostfix(String expression) {

        // stack used for operators and parentheses
        Deque<Character> stack = new ArrayDeque<>();

        // stores final postfix expression
        StringBuilder postfix = new StringBuilder();

        // traverse each symbol of infix expression
        for (char symbol : expression.toCharArray()) {

            // if current symbol is operator or parenthesis
            if (isOperator(symbol)) {

                // opening parenthesis always push into stack
                if (symbol == '(') {

                    stack.push(symbol);

                }
                // closing parenthesis found
                else if (symbol == ')') {

                    // pop everything until opening parenthesis is found
                    while (stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }

                    // remove opening parenthesis from stack
                    stack.pop();
                }

                // current symbol is operator (+,-,*,/,^)
                else {

                    /*
                     * POP CONDITIONS:
                     *
                     * 1. Stack top precedence > current operator precedence
                     * 2. Same precedence and current operator is LEFT associative
                     * 3. when closing parentheses are current operator then pop operator till opening parentheses
                     
                     * PUSH CONDITIONS:
                     * 1. Stack empty
                     * 2. Stack top is '('
                     * 3. Stack top precedence is lower
                     * 4. Same precedence and current operator is RIGHT associative (^)
                     */

                    while (!stack.isEmpty()
                            && stack.peek() != '('
                            && (
                                checkPrecedence(stack.peek()) > checkPrecedence(symbol)
                                ||
                                (
                                    checkPrecedence(stack.peek()) == checkPrecedence(symbol)
                                    && !isRightAssociative(symbol)
                                )
                            )) {

                        // move operator from stack to postfix
                        postfix.append(stack.pop());
                    }

                    // finally push current operator into stack
                    stack.push(symbol);
                }
            }

            // operand directly goes to postfix
            else {
                postfix.append(symbol);
            }
        }

        // pop all remaining operators from stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        // return final postfix expression
        return postfix.toString();
    }
}

public class InfixToPostfixConversion {
    public static void main(String[] args) {

        String infix = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";

        String postfix = new Solution().infixToPostfix(infix);

        System.out.println(postfix);
    }
}
