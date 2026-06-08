import java.util.Queue;
import java.util.ArrayDeque;

class Solution{

     // function to get the first unique character in current stream
     private char getFirstUniqueChar(Queue<Character> currentStream, int[] repeated){
        while(!currentStream.isEmpty()){
            if(repeated[currentStream.peek() - 'a'] > 1){
               currentStream.poll();
            }
            else break;
        }
        return currentStream.isEmpty() ? '#' : currentStream.peek();
     }
    // function to get the first no repeating character of stream
    String getFirstNoRepeatingChar(String str){
        int[] repeated = new int[26];
        int n = str.length();
        Queue<Character> currentStream = new ArrayDeque<>();
        String ans = "";

        for(int i = 0; i < n; i++){
             char currentChar = str.charAt(i);
            
             repeated[currentChar - 'a']++;
             // kya currentChar ko queue me store karna chahiye 
              if(repeated[currentChar - 'a'] <= 1){
                 currentStream.offer(currentChar);
              }
              // get first unique character in current stream
              char ch = getFirstUniqueChar(currentStream , repeated);
              ans = ans + ch;

        }
        return ans;
    }
}
class GetFirstNoRepeatingCharInStream2{
    public static void main(String[] args){
      String str = "abcacdbd";

      String ans = new Solution().getFirstNoRepeatingChar(str);
      System.out.println(ans);
    }
}
