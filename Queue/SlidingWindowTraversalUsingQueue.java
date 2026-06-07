import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

  // function to display queue element
  private void display(Queue<Integer> queue) {
    int size = queue.size();

    while (size > 0) {
      int data = queue.poll();
      System.out.print(data + " ");
      queue.offer(data);
      size--;
    }
    System.out.println();
  }

  // function to get the sliding window using queue
  void slidingWindow(int[] arr, int k) {

    int n = arr.length;
    
    if (k <= 0 || k > n) {
      return;
    }
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < k; i++) {
      queue.offer(arr[i]);
    }
    display(queue);

    for (int i = k; i < n; i++) {
      queue.poll();
      queue.offer(arr[i]);
      display(queue);
    }
  }
}

public class SlidingWindowTraversalUsingQueue {
  public static void main(String[] args) {

    int[] arr = { 3, 6, 2, 7, 8, 11 };

    int k = 3;

    new Solution().slidingWindow(arr, k);

  }
}
