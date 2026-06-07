package FirstNegativeIntegerForEveryWindowSize;

import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {

    private int getFirstNegativeInWindow(Queue<Integer> queue) {

        int negative = 0;
        boolean flag = true;
        int size = queue.size();

        while (size > 0) {
            int data = queue.poll();
            if (data < 0 && flag) {
                negative = data;
                flag = false;
            }
            queue.offer(data);
            size--;
        }
        return negative;
    }

    // get the first negative integer for every window size
    List<Integer> getNegative(int[] arr, int k) {

        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        ans.add(getFirstNegativeInWindow(queue));

        for (int i = k; i < n; i++) {
            queue.poll();
            queue.offer(arr[i]);
            ans.add(getFirstNegativeInWindow(queue));
        }
        return ans;
    }
}

public class FirstNegativeIntegerForEveryWindowSize {
   public static void main(String[] args) {
      int[] arr = {2, -3, -4,-2 , 7 , 8, 9, -10};

      int k = 3;
      
      List<Integer> ans = new Solution().getNegative(arr, k);

      System.out.println(ans);
    }
}
