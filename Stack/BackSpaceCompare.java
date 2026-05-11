import java.util.Stack;

class Solution {

    // backspace string compare
    boolean backspaceString(String str1, String str2) {

        Stack<Character> stack = new Stack<>();

        // first string process
        for (char ch : str1.toCharArray()) {

            if (ch == '#') {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(ch);
            }
        }

        StringBuilder s1 = new StringBuilder();

        while (!stack.isEmpty()) {
            s1.append(stack.pop());
        }

        // second string process
        for (char ch : str2.toCharArray()) {

            if (ch == '#') {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(ch);
            }
        }

        StringBuilder s2 = new StringBuilder();

        while (!stack.isEmpty()) {
            s2.append(stack.pop());
        }

        return s1.toString().equals(s2.toString());
    }
}

public class BackSpaceCompare {

    public static void main(String[] args) {

        String str1 = "ab#c";
        String str2 = "ad#c";

        boolean flag = new Solution().backspaceString(str1, str2);

        System.out.println(flag);
    }
}
