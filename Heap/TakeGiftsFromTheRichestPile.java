

class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Store each array element in the Max-Heap
        for (int gift : gifts) {
            pq.offer(gift);
        }

        int time = k;

        while (time > 0 && !pq.isEmpty()) {

            int maxGift = pq.poll();

            int x = (int) Math.sqrt(maxGift);

            pq.offer(x);

            time--;
        }

        long sum = 0;

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
