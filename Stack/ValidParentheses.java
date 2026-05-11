
import java.util.Stack;

class Solution {

  // check opening and closing bracket is matched or not
  private boolean isMatch(char ch1, char ch2) {
    if (ch1 == '(' && ch2 == ')') {
      return true;
    } else if (ch1 == '[' && ch2 == ']') {
      return true;
    } else if (ch1 == '{' && ch2 == '}') {
      return true;
    } else {
      return false;
    }
  }

  // check Valid Parentheses
  boolean isValidParentheses(String str) {

    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
      } else if (ch == ')' || ch == ']' || ch == '}') {
        if (stack.isEmpty()) {
          System.out.println("Right Brackets is more than left Brackets!");
          return false;
        }
        if (!isMatch(stack.peek(), ch)) {
          System.out.println("Mismatched Brackets!");
          return false;
        } else {
          stack.pop();
        }
      }
    }
    if (!stack.isEmpty()) {
      System.out.println("Left brackets are more than right brackets!");
      return false;
    }
    System.out.println("Brackets are well balanced.");
    return true;
  }
}

public class ValidParentheses {
  public static void main(String[] args) {
    String str = "(a+b)*{c-d}";

    boolean isValid = new Solution().isValidParentheses(str);
    System.out.println(isValid);
  }
}
