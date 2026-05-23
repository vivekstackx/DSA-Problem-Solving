class Solution {

/* We start with two pointers from both ends. At each step, we eliminate at
least one non-celebrity. Eventually only one candidate remains, which may or
may not be celebrity, so we verify it.
*/

    int celebrity(int[][] matrix) {
        int n = matrix.length;

        int i = 0;
        int j = n - 1;

        // Step 1: find candidate
        while (i < j) // jab tak 2 candidates bache hain, compare karo aur ek ko eliminate karo 

            if (matrix[i][j] == 1) {
                i++;   // i knows j → i is not celebrity
            } else {
                j--;   // i doesn't know j → j is not celebrity
            }
        }

        int candidate = i;

        // Step 2: verify candidate
        for (int k = 0; k < n; k++) {
            if (k == candidate) continue;

            if (matrix[candidate][k] == 1 || matrix[k][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }
}
