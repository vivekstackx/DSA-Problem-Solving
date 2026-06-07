package FirstNegativeIntegerForEveryWindowSize2;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    // function to check a number is negative or not
    private boolean isNegative(int num) {
        return num < 0 ? true : false;
    }

    // function to get the first negative Integer for every window size
    List<Integer> getFirstNegativeInteger(int[] arr, int k) {

        int n = arr.length;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (isNegative(arr[i])) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            ans.add(0);
        } else {
            ans.add(arr[queue.peek()]);
        }

        for (int i = k; i < n; i++) {
            if (queue.isEmpty()) {
                if (isNegative(arr[i])) {
                    queue.offer(i);
                }
            } else {
                int windowSize = i - queue.peek() + 1;
                if (windowSize <= k) {
                    if (isNegative(arr[i])) {
                        queue.offer(i);
                    }
                } else { 
                    queue.poll();
                    if (isNegative(arr[i])) {
                        queue.offer(i);
                    }
                }
            }
            if (queue.isEmpty()) {
                ans.add(0);
            } else {
                ans.add(arr[queue.peek()]);
            }

        }
        return ans;
    }
}

public class FirstNegativeIntegerForEveryWindowSize2 {
    public static void main(String[] args) {
      int[] arr = {2, -3, -4,-2 , 7 , 8, 9, -10};

      int k = 3;
      
      List<Integer> ans = new Solution().getFirstNegativeInteger(arr, k);

      System.out.println(ans);
    }
}
