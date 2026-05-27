import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            
            for (int j = 0; (n - j) >= i; j++) {
                int min = Integer.MAX_VALUE;
            
                for (int k = j; k < j + i; k++) {
                    min = Math.min(min, arr[k]);
                }
                max = Math.max(max, min);
            }
            ans.add(max);
        }
        return ans;
    }
    }
