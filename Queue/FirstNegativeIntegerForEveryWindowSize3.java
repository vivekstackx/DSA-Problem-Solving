import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    // Time Complexity : O(n)
    // Space Complexity : O(k)

    List<Integer> firstNegativeInteger(int[] arr, int k) {

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // store negative element index
            if (arr[i] < 0) {
                queue.offer(i);
            }

            // window formed
            if (i >= k - 1) {

                // remove indices outside current window
                while (!queue.isEmpty() && queue.peek() <= i - k) {
                    queue.poll();
                }

                // first negative of current window
                if (queue.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(arr[queue.peek()]);
                }
            }
        }

        return ans;
    }

    
     List<Integer> firstNegativeInteger2(int[] arr, int k) {

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // store negative element index
            if (arr[i] < 0) {
                queue.offer(i);
            }

            // window formed
            if (i >= k - 1) {

                // remove indices outside current window
                 if(!queue.isEmpty() && queue.peek() <= i - k) {
                    queue.poll();
                }

                // first negative of current window
                if (queue.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(arr[queue.peek()]);
                }
            }
        }

        return ans;
    }

    // display list
    void display(List<Integer> list) {
        System.out.println(list);
    }
}

public class FirstNegativeIntegerForEveryWindowSize3 {

    public static void main(String[] args) {

        int[] arr = {2, -3, -4, -2, 7, 8, 9, -10};
        int k = 3;

        Solution obj = new Solution();

        List<Integer> ans = obj.firstNegativeInteger(arr, k);

        obj.display(ans);
    }
}
