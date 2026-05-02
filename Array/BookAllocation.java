/*
 jab v hame array ko "k" (1,2,3 etc) tukro me devide karna h or har tukro ka sum nikalna h or 
 fir sabhi tukro ka sum me jis tukro ka minimum sum hoga usko return karna h to vanha pe 
 book allocation vala same logic lagega
 jaise ki leetcode 410 problem and 1011 vala problem bilkul same iasi logic pe based hai

 jaise ki ---
 ## Example 1 Ka Breakdown Aapke paas array hai: [7, 2, 5, 10, 8] aur k = 2 -----
 ias array ko 2 tukdon mein todne (split karne) ke 4 tareeqe ho sakte hain:
 Split 1: [7] aur [2, 5, 10, 8]
 Sums: 7 aur 25.
 Maximum sum in dono me se: max(7, 25) = 25 
 Split 2: [7, 2] aur [5, 10, 8]
 Sums: 9 aur 23.
 Maximum sum in dono me se: max(9, 23) = 23
 Split 3: [7, 2, 5] aur [10, 8]
 Sums: 14 aur 18.
 Maximum sum in dono me se: max(14, 18) = 18.
 Split 4: [7, 2, 5, 10] aur [8]
 Sums: 24 aur 8.
 Maximum sum in dono me se: max(24, 8) = 24.
 Ab in sabhi max sums [25, 23, 18, 24] mein se sabse chota (minimized) value kya hai? 18.Isliye output 18 aata hai!
*/
class Solution {

    // check book allocate for specific mid (pages)
    private boolean canWeAllocatePageFor(int[] books, int mid, int M) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < books.length; i++) {
            if (pages + books[i] <= mid) {
                pages = pages + books[i];
            } else {
                students++;
                pages = books[i];
            }
        }
        return students <= M;
    }

    // function to allocate the books between students
    int bookAllocate(int[] books, int M) {
        if (M > books.length) {
            return -1;
        }
        // calculate the sum of books page and get max pages book
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < books.length; i++) {
            sum = sum + books[i];
            if (books[i] > max) {
                max = books[i];
            }
        }
        // implement binary search
        int start = max;
        int end = sum;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canWeAllocatePageFor(books, mid, M)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

public class BookAllocation {
    public static void main(String[] args) {

        int[] books = new int[] { 2, 1, 3, 4 };
        int M = 2;

        int ans = new Solution().bookAllocate(books, M);

        System.out.println(ans);
    }
}
