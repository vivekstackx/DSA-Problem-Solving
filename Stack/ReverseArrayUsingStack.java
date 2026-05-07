
class Solution {

    // private nested class (Stack class only access from Solution class not any other class)
     private class Stack {
        private char[] arr;
        private int top;
        private int size;

        Stack(int size) {
            this.arr = new char[size];
            this.top = -1;
            this.size = size;
        }

        // check stack empty
        boolean isEmpty() {
            return top == -1;
        }

        // check stack full
        private boolean isFull() {
            return top == size - 1;
        }

        // push data
        void push(char c) {
            if (isFull()) {
                return;
            }
            top++;
            arr[top] = c;
        }

        // pop data
        char pop() {
            if (isEmpty()) {
                return '\0';
            }
            char temp = arr[top];
            top--;
            return temp;
        }

    }
     // reverse array using stack
    void reverseArray(char[] arr) {
        if (arr.length == 0) {
            return;
        }

        Stack stack = new Stack(arr.length);

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        int j = 0;
        while (!stack.isEmpty()) {
            arr[j] = stack.pop();
            j++;
        }
    }

    // reverse Array using 2 pointer approch
   public void reverseString(char[] s) {
        Stack stack = new Stack(s.length);

         for(int i = 0; i < s.length; i++){
             stack.push(s[i]);
         }

         int j = 0;
         while(!stack.isEmpty()){
             s[j] = stack.pop();
             j++;
         }
    }
   
}

public class ReverseArrayUsingStack {
    public static void main(String[] args) {

        Solution obj = new Solution();

        char[] ch = new char[] { 'a', 'b', 'c', 'd' };

        System.out.println(ch);
        
        obj.reverseString(ch);

        System.out.println(ch);

    }
}


