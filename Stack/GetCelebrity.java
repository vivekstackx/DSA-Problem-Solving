import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    int celebrity(int[][] matrix) {
        int n = matrix.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 1: eliminate candidates
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (matrix[a][b] == 1) {
                stack.push(b); // a knows b → a not celebrity
            } else {
                stack.push(a); // a doesn't know b → b not celebrity
            }
        }

        // Step 2: verification
        int cand = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == cand) continue;

            if (matrix[cand][i] == 1 || matrix[i][cand] == 0) {
                return -1;
            }
        }

        return cand;
    }
}

public class GetCelebrity {
    public static void main(String[] args) {
    int[][] matrix = { 
      {0,1,0,1,1},
      {0,0,0,1,1},
      {0,1,0,1,0},
      {0,0,0,0,0},
      {1,0,1,1,0}
      };
      
       int celebrity = new Solution().celebrity(matrix);
       System.out.println(celebrity);
    
    }
}
