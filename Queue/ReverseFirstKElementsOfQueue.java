import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    // function to reverse first K elements of queue
    Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {

        Deque<Integer> stack = new ArrayDeque<>();

        while (k > 0) {
           stack.push(queue.poll());
           k--;
        }

       int size = queue.size();
       while(!stack.isEmpty()){
        queue.offer(stack.pop());
       }

       while(size > 0){
         queue.offer(queue.poll());
         size--;
       }
     return queue;
    }
}

public class ReverseFirstKElementsOfQueue {
    public static void main(String[] args) {
         
        Solution obj = new Solution();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(3);
        queue.offer(7);
        queue.offer(10);
        queue.offer(13);
        queue.offer(8);
        queue.offer(5);
        queue.offer(4);

        int k = 3;

        Queue<Integer> ans = obj.modifyQueue(queue, k);

        System.out.println(ans);
    }

}
