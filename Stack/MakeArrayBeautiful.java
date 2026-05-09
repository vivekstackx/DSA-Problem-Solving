
// creating stack

import java.util.Arrays;

class Stack {
    private int[] arr;
    private int top;
    private int size;

    Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.size = size;
    }

    // check stack is empty or not
    boolean isEmpty() {
        return top == -1;
    }

    // check stack is full or not
   private boolean isFull() {
        return top == size - 1;
    }

    // push operation
    void push(int data) {
        if (isFull()) {
            return;
        }
        top++;
        arr[top] = data;
    }

    // pop operation
    int pop() {
        if (isEmpty()) {
            return -1;
        }
        int temp = arr[top];
        top--;
        return temp;
    }

    // peek operation
    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }

    // get size of stack
    int getSize() {
        return top + 1;
    }
}

class Solution {
    // make array beautiful
    int[] makeBeauty(int[] arr) {
        if (arr.length == 0) {
            return new int[0]; // empty array
        }

        Stack stack = new Stack(arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if ((arr[i] >= 0 && stack.peek() >= 0) || (arr[i] < 0 && stack.peek() < 0)) {
                stack.push(arr[i]);
            } else {
                stack.pop();
            }
        }
        int[] ans = new int[stack.getSize()];
        int i = ans.length - 1;

        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;

    }
}

public class MakeArrayBeautiful {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] ans = obj.makeBeauty(new int[] {2,-2, -1, 1});

        System.out.println(Arrays.toString(ans));

    }
}
