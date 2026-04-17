
class Solution {

    // get fibonacci data by position
    int getFibonacciValue(int N, int position) {

        if (N < 0 || position < 1 || position > N) {
            return -1;
        }

        if (N == 1) {
            return 0;
        }

        int[] arr = new int[N];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < N; i++) {
            int first = arr[i - 2];
            int second = arr[i - 1];
            arr[i] = first + second;
        }
        return arr[position - 1];

    }
}

public class GetFibonacciDataByPos {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int N = 50;
        int position = 8;

        System.out.println(obj.getFibonacciValue(N, position));
    }
}
