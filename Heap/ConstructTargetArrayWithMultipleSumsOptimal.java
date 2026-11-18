
/*
------------Test case for all edge cases---------------------

Single element valid: [1] → true

Single element invalid: [2] → false

All ones (multi-element): [1, 1, 1] → true

Already valid early exit: [2, 1] → true

maxValue == remSum (exact equal): [2, 2] → false

maxValue < remSum (smaller max): [2, 3, 1] → false

maxValue > remSum initially, later hits maxValue == remSum: [4, 2, 1] → false

remSum == 1 (fast reduction to 1): [1, 100] → true

remSum == 1 with multiple 1s: [1, 1, 100] → false (remSum == 2, 100 % 2 == 0)

element == 0 with remSum > 1 (exact multiple of remSum): [3, 6] → false

element == 0 with remSum > 1 (another multiple): [2, 6] → false

Multiple steps with modulo jump: [9, 3, 5] → true

Large value / overflow test (long): [1, 1000000000] → true

Zero in array (if non-LeetCode input): [2, 0] → false (or 0 in target if allowed)

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
