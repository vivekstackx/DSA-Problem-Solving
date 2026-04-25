
class Solution{
     
    // function to get the sqrt root of number
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }

        int start = 1;
        int end = x;
        int sqrtRoot = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == x / mid) { // instead of if(mid * mid == x)
                return mid;
            } else if (mid > x / mid) { // instead of if(mid * mid > x)
                end = mid - 1;
            } else {
                sqrtRoot = mid;
                start = mid + 1;
            }
        }
        return sqrtRoot;
    }
}

public class SqrtRoot {
     public static void main(String[] args){
         Solution obj = new Solution();

         int num = 80;

         int sqrtRoot = obj.mySqrt(num);
         System.out.println(sqrtRoot);

     }
}
