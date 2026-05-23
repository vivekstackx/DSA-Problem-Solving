import java.util.Deque;
import java.util.ArrayDeque;
/*
 celebrity ki pahchan ye h ki celebrity kisi ko nahi janta ho or har koi celebrity ko janta ho
*/
class Solution {

    int celebrity(int[][] matrix) {
        int n = matrix.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 1: eliminate candidates
        while (stack.size() > 1) {
            int firstPerson = stack.pop();
            int secondPerson = stack.pop();

            if (matrix[firstPerson][secondPerson] == 1) {
                stack.push(secondPerson); // a knows b → a not celebrity
            } else {
                stack.push(firstPerson); // a doesn't know b → b not celebrity
            }
        }

        // Step 2: verification
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            if (matrix[candidate][i] == 1 || matrix[i][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }
}

public class GetCelebrityM2 {
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
