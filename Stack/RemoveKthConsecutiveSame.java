import java.util.*;

class StackNode {
  char ch;
  int count;

  StackNode(char ch, int count) {
    this.ch = ch;
    this.count = count;
  }
}

class MyStack {
  private StackNode[] arr;
  private int top;
  private int size;

  MyStack(int size) {
    this.arr = new StackNode[size];
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
  void push(StackNode node) {
    if (isFull()) {
      return;
    }
    top++;
    arr[top] = node;
  }

  // pop operation
  StackNode pop() {
    if (isEmpty()) {
      return null;
    }
    StackNode temp = arr[top];
    top--;
    return temp;
  }

  // peek operation
  StackNode peek() {
    if (isEmpty()) {
      return null;
    }
    return arr[top];
  }
}

class Solution {
  // function to remove the dublicate consecutive character
  String removeConsecutive(String str, int k) {
    if (str.length() == 0) {
      return "";
    }
    MyStack stack = new MyStack(str.length());

    for (char ch : str.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(new StackNode(ch, 1));
      } else if (ch != stack.peek().ch) {
        stack.push(new StackNode(ch, 1));
      } else {
        StackNode peekNode = stack.peek();

        peekNode.count++;
        if (peekNode.count == k) {
          stack.pop();
        }
      }
    }

    StringBuilder ans = new StringBuilder();

    while (!stack.isEmpty()) {
      StackNode node = stack.pop();

      for (int i = 1; i <= node.count; i++) {
        ans.append(node.ch);
      }
    }

    return ans.reverse().toString();
  }
}

public class RemoveKthConsecutiveSame {
  public static void main(String[] args) {
    Solution obj = new Solution();

    String str = "deeedbbcccbdaa";
    int k = 3;

    String ans = obj.removeConsecutive(str, k);

    System.out.println(ans);
  }
}
