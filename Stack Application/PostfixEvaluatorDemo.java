import java.util.Deque;
import java.util.ArrayDeque;

class PostfixEvaluator {

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/") ||
               s.equals("^");
    }

    double evaluatePostfix(String[] exp) {

        Deque<Double> stack = new ArrayDeque<>();

        for (String symbol : exp) {

            if (isOperator(symbol)) {

                double first = stack.pop();
                double second = stack.pop();

                switch (symbol) {
                    case "+": stack.push(second + first); break;
                    case "-": stack.push(second - first); break;
                    case "*": stack.push(second * first); break;
                    case "/": stack.push(second / first); break;
                    case "^": stack.push(Math.pow(second, first)); break;
                }

            } else {
                stack.push(Double.parseDouble(symbol));
            }
        }

        return stack.pop();
    }
}

public class PostfixEvaluatorDemo {
    public static void main(String[] args) {

        String[] exp = {"7","5","9","/","-"};

        System.out.println(new PostfixEvaluator().evaluatePostfix(exp));
    }
}
