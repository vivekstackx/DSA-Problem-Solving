package TimeNeededToBuyTickets;

import java.util.Queue;
import java.util.ArrayDeque;

/*
  front person 1 ticket buy karega
  ticket count--
  agar tickets bachi hain -> line ke end me
  warna line se bahar
 */

class Solution {

    // get the time needed to buy tickets
    int timeRequiredToBuy1(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        if (k > n - 1 || k < 0) {
            return time;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // store the index of array in queue
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int person = queue.poll();
            tickets[person]--;
            if (tickets[person] >= 0) {
                time++;
            }
            if (tickets[person] == 0) {
                if (person == k) {
                    return time;
                }
            } else {
                if (tickets[person] > 0) {
                    queue.offer(person);
                }
            }
        }
        return time;
    }

    // function to get the time needed to buy tickets
    int timeRequiredToBuy2(int[] tickets, int k) {

        int n = tickets.length;

        if (k > n - 1 || k < 0) {
            return 0;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // store each index of ticket in queue
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        int time = 0;

        while (tickets[k] != 0) {
            int person = queue.poll();

            tickets[person]--;
            // kya ye person line me lagna chahiye
            if (tickets[person] > 0) {
                queue.offer(person);
            }

            time++;

        }
        return time;
    }

    // function to get the time needed to buy tickets
    // Time complexity : O(n)
    int timeRequiredToBuy3(int[] tickets, int k) {

        int n = tickets.length;
        int time = 0;

        for (int i = 0; i < n; i++) {
            // left part
            if (i < k) {
                if (tickets[i] < tickets[k]) {
                    time = time + tickets[i];
                } else {
                    time = time + tickets[k];
                }
            }
            // right part
            else if (i > k) {
                if (tickets[i] < tickets[k]) {
                    time = time + tickets[i];
                } else {
                    time = time + tickets[k] - 1;
                }
            } else {
                time = time + tickets[k];
            }
        }
        return time;
    }

    int timeRequiredToBuy4(int[] tickets, int k) {

        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            // left part and itself
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            }
            // right part
            else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {

        int[] arr = { 1, 5, 2, 3, 7 };
        int k = 2;

        int time3 = new Solution().timeRequiredToBuy2(arr, k);
        System.out.println(time3);

    }
}
