
class Solution {
    
    private int top1;
    private int top2;
    private int[] arr;
    private int n;

    Solution(int n) {
        this.n = n;
        this.top1 = -1;
        this.top2 = n;
        this.arr = new int[n];
    }

    // push operation for stack first
    void push1(int data) {
        if (top1 + 1 == top2) {
            System.out.println("Stack first overflow !");
            return;
        }
        top1++;
        arr[top1] = data;
    }

    // push operation for stack second
    void push2(int data) {
        if (top2 - 1 == top1) {
            System.out.println("Stack second overflow !");
            return;
        }
        top2--;
        arr[top2] = data;
    }

    // pop operation for stack first
    int pop1() {
        if (top1 == -1) {
            System.out.println("Stack first underflow !");
            return -1;
        }
        int current = arr[top1];
        top1--;
        return current;
    }

    // pop operation for stack second
    int pop2() {
        if (top2 == n) {
            System.out.println("Stack second underflow !");
            return -1;
        }
        int current = arr[top2];
        top2++;
        return current;
    }
}

public class TwoStackInAnArray {
    public static void main(String[] args) {

        int size = 7;
        Solution obj = new Solution(size);

        obj.pop1();
    }
}
