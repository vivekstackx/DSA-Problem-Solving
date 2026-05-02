/*
 jab v hame array ko "k" (1,2,3 etc) tukro me devide karna h or har tukro ka sum nikalna h or 
 fir sabhi tukro ka sum me jis tukro ka minimum sum hoga usko return karna h to vanha pe 
 book allocation vala same logic lagega
 jaise ki leetcode 410 problem and 1011 vala problem bilkul same iasi logic pe based hai
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
