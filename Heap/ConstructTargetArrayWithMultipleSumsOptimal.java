
/*
 Test cases for all edge cases : ) 

 [1] → true

[2] → false

[1, 1, 1] → true

[2, 1] → true

[2, 2] → false

[2, 3, 1] → false

[4, 2, 1] → false

[1, 100] → true

[1, 1, 100] → false

[3, 6] → false

[2, 6] → false

[9, 3, 5] → true

[5, 8] → true

[1, 1000000000] → true

[2, 0] → false

*/

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;

        for (int i = 0; i < target.length; i++) {
            maxHeap.offer((long) target[i]);
            sum += (long) target[i];
        }

        while (true) {
            long maxValue = maxHeap.poll();
            if (maxValue == 1) {
                return true;
            }

            long remSum = sum - maxValue;
            if (remSum == 0 || maxValue <= remSum) {
                return false;
            }
            if (remSum == 1) {
                return true;
            }

            long element = maxValue % remSum;
            if (element == 0) {
                return false;
            }

            sum = remSum + element;
            maxHeap.offer(element);
        }
    }
}
