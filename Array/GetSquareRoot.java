
class Solution {

    // function to get the square root of given number
    int getSqrtLinear(int number) {

        if (number < 0) {
            return -1;
        }

        int i = 1;

        while (i * i <= number) { // Avoid overflow using while (i <= number / i)
            i++;
        }

        return i - 1;
    }

    // function to get the squre root of given numbern (binary search approch recommended)
    int getSqrtBinarySearch(int number) {
        if (number == 0) {
            return 0;
        }

        int start = 0;
        int end = number;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid * mid == number) { //  Avoid overflow using division use this if (mid == number / mid)
                return mid;
            } else if (mid * mid > number) { // Avoid overflow using division use this else if (mid > number / mid) 
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;

    }
}

public class GetSquareRoot {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int number = 100;

        System.out.println(obj.getSqrtLinear(number));

        System.out.println("-------------");

        System.out.println(obj.getSqrtBinarySearch(number));
    }
}
