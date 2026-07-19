class ArrayStorage {

    private int[] arr;
    private int top1;
    private int top2;

    ArrayStorage(int size) {
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    // Check whether both stacks have occupied the whole array
    private boolean isFull() {
        return top1 + 1 == top2;
    }

    // Check whether Stack 1 is empty
    boolean isEmptyStackFirst() {
        return top1 == -1;
    }

    // Check whether Stack 2 is empty
    boolean isEmptyStackSecond() {
        return top2 == arr.length;
    }

    // Push into Stack 1
    void pushInStackFirst(int data) {

        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }

        arr[++top1] = data;
    }

    // Push into Stack 2
    void pushInStackSecond(int data) {

        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }

        arr[--top2] = data;
    }

    // Pop from Stack 1
    int popFromStackFirst() {

        if (isEmptyStackFirst()) {
            System.out.println("Stack 1 Underflow!");
            return -1;
        }

        return arr[top1--];
    }

    // Pop from Stack 2
    int popFromStackSecond() {

        if (isEmptyStackSecond()) {
            System.out.println("Stack 2 Underflow!");
            return -1;
        }

        return arr[top2++];
    }

    // Peek Stack 1
    int peekOfStackFirst() {
        return isEmptyStackFirst() ? -1 : arr[top1];
    }

    // Peek Stack 2
    int peekOfStackSecond() {
        return isEmptyStackSecond() ? -1 : arr[top2];
    }

    // Display both stacks
    void display() {

        System.out.println("\nStack 1:");

        if (isEmptyStackFirst()) {
            System.out.println("Empty");
        } else {
            for (int i = top1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }

        System.out.println("\nStack 2:");

        if (isEmptyStackSecond()) {
            System.out.println("Empty");
        } else {
            for (int i = top2; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        ArrayStorage stack = new ArrayStorage(10);

        stack.pushInStackFirst(3);
        stack.pushInStackFirst(9);
        stack.pushInStackFirst(7);

        stack.pushInStackSecond(12);
        stack.pushInStackSecond(67);

        stack.pushInStackFirst(11);
        stack.pushInStackSecond(44);
        stack.pushInStackSecond(22);

        stack.pushInStackFirst(97);

        System.out.println(stack.popFromStackFirst());
        System.out.println(stack.peekOfStackFirst());

        System.out.println(stack.popFromStackSecond());
        System.out.println(stack.peekOfStackSecond());

        stack.display();
    }
}
