
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
    boolean isFull() {
        return top == size - 1;
    }

    // push operation on stack
    void push(int data) {
        if (isFull()) {
            System.out.println("stack Overflow !");
            return;
        }
        top++;
        arr[top] = data;
        System.out.println(data + " Data is pushed in stack.");
    }

    // pop operation on stack
    void pop() {
        if (isEmpty()) {
            System.out.println("stack Underflow !");
            return;
        }
        int temp = arr[top];
        top--;
        System.out.println(temp + " Data is popped from stack.");
    }

    // peek operation on stack
    int peek() {
        if (isEmpty()) {
            System.out.println("stack Empty !");
            return -1;
        }
        System.out.println("peek data is : " + arr[top]);
        return arr[top];
    }

    // check size of array for data
    int getSize() {
        return top + 1;
    }

    // display stack
    void displayStack() {
        if (isEmpty()) {
            System.out.print("stack Empty !\n");
            return;
        }
        System.out.println("stack is : ");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

}

public class ImplementStackUsingArray {
    public static void main(String[] args) {
        int size = 5;
        Stack stack = new Stack(size);

        stack.displayStack(); // stack empty

        // push data
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.displayStack();

        // peek data
        stack.peek();

        // pop data
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.displayStack();

        // is stack empty
        System.out.println(stack.isEmpty());

        // is stack full
        System.out.println(stack.isFull());

        // get total data count
        System.out.println(stack.getSize());

    }
}
