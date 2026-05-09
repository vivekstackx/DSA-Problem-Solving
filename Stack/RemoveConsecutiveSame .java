// create the stack 
class Stack {
    private String[] arr;
    private int top;
    private int size;

    Stack(int size) {
        this.arr = new String[size];
        this.top = -1;
        this.size = size;
    }

    // check stack is empty or not
    boolean isEmpty() {
        return top == -1;
    }

    // check stack is full or not
    boolean isFull() {
        return top == size - 1;
    }

    // push operation
    void push(String data) {
        if (isFull()) {
            return;
        }
        top++;
        arr[top] = data;
    }

    // pop operation
    String pop() {
        if (isEmpty()) {
            return "";
        }
        String temp = arr[top];
        top--;
        return temp;
    }

    // peek operation
    String peek() {
        if (isEmpty()) {
            return "";
        }
        return arr[top];
    }

    // get the size of the stack
    int getSize() {
        return top + 1;
    }
}

class Solution {
    // string manipulation
    int remove(String[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        Stack stack = new Stack(arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } 
            else if(!arr[i].equals(stack.peek())){
                stack.push(arr[i]);
            }
            else {
                stack.pop();
            }
        }

        return stack.getSize();

    }
}

class RemoveConsecutiveSame {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int ans = obj.remove(new String[] { "ab", "ac", "da", "da", "ac", "db", "ea" });

        System.out.println(ans);
    }
}
