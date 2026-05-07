import java.util.Stack;

class Solution {
    // insert at bottom
    Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        // create temporary stack
        Stack<Integer> temp = new Stack<>();

        while (!st.empty()) {
            temp.push(st.pop());
        }
        // insert new data
        st.push(x);

        while (!temp.empty()) {
            st.push(temp.pop());
        }

        return st;
    }
}

public class InsertAtBottomInStack {
    public static void main(String[] args) {
           Stack<Integer> stack = new Stack<>();

           stack.push(10);
           stack.push(20);
           stack.push(30);

      Stack<Integer> ans = new Solution().insertAtBottom(stack, 100);

       System.out.println(stack);
    }
}
