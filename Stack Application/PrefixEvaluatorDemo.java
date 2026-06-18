import java.util.Deque;
import java.util.ArrayDeque;

class PrefixEvaluator {

    // Check whether current symbol is an operator
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/") ||
               s.equals("^");
    }

    // Evaluate prefix expression
    double evaluatePrefix(String[] prefix) {

        // Stack stores operands and intermediate results
        Deque<Double> stack = new ArrayDeque<>();

        // Traverse prefix expression from right to left
        for (int i = prefix.length - 1; i >= 0; i--) {

            String symbol = prefix[i];

            // If current symbol is an operator
            if (isOperator(symbol)) {

                // First popped value becomes left operand
                double first = stack.pop();

                // Second popped value becomes right operand
                double second = stack.pop();

                // Perform operation and push result back
                switch (symbol) {

                    case "+":
                        stack.push(first + second);
                        break;

                    case "-":
                        stack.push(first - second);
                        break;

                    case "*":
                        stack.push(first * second);
                        break;

                    case "/":
                        stack.push(first / second);
                        break;

                    case "^":
                        stack.push(Math.pow(first, second));
                        break;
                }

            } else {

                // Operand directly goes into stack
                stack.push(Double.parseDouble(symbol));
            }
        }

        // Final answer will be present at top of stack
        return stack.pop();
    }
}

public class PrefixEvaluatorDemo {

    public static void main(String[] args) {

        // Prefix expression:
        // * 12 (+ 234 978)
        String[] exp = {"*", "12", "+", "234", "978"};

        double answer = new PrefixEvaluator().evaluatePrefix(exp);

        System.out.println(answer);
    }
}
