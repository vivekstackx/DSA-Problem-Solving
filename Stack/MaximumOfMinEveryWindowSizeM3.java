import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


class Solution{
    // function to get the next smallest element
    private int[] getNextSmallestElement(int[] arr){

         Deque<Integer> stack = new ArrayDeque<>();

         int n = arr.length;
         int[] ans = new int[n];

         for(int i = 0; i < n; i++){
             
             while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                ans[stack.pop()] = i;
             }
             stack.push(i);
         }
         while(!stack.isEmpty()){
            ans[stack.pop()] = n;
         }
         
         return ans;
     }
     // function to get the previous smallest element
     private int[] getPreviousSmallestElement(int[] arr){

         Deque<Integer> stack = new ArrayDeque<>();
         int n = arr.length;
         int[] ans = new int[n];

         for(int i = n-1; i >= 0; i--){
            
             while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                ans[stack.pop()] = i;
             }
             stack.push(i);
         }
         while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
         }
         return ans;
     }
     // function to get the maximum of minimum for every window size
     int[] maxOfMins(int[] arr){

         int n = arr.length;
         int[] previousSmallest = getPreviousSmallestElement(arr);
         int[] nextSmallest = getNextSmallestElement(arr);
         int[] ans = new int[n];
 
         Arrays.fill(ans , Integer.MIN_VALUE);

         for(int i = 0; i < n; i++){
            int nextSmall = nextSmallest[i];
            int previousSmall = previousSmallest[i];

            int windowSize =  nextSmall - previousSmall - 1;

            /*
             agr koi element total 3 window size ke lie minimum hota h ,
             to aap ek loop ka use kar ke uan sabhi element ko min se update kr 
             sakte h yani 0 < 3 tak run kar ke ,isse v correct output aayega,
             but iasse problem ye h ki time 
             complexity O(N2) aa jati h jabki mujhe O(N) me solve karna h , 
             to uske lie sabhi element ko min se update karne ki need nahi h ham only
             last element ko udpate karenge yani agar window size h 3 to 3 vala index yani
             jo last index hoga usko update kr denge , kyunki mujhe pata h ki agar koi 
             element total 3 window size ke lie minimum h to ye baat 100% sure h window size 
              1 and 2 ka v min logically last vala hi hona chahiye, agar 1 and 2 ka element 
              already smaller h to , yani ki Agar window size 1 aur 2 ke liye koi bada candidate nahi milta,
              to window size 3 ke liye jo value answer bani hai wahi 1 aur 2 ke answer ko bhi fill kar sakti hai.
              or fir sabhi operation perform karne ke baad ham 
             ek reverse order me loop run kar denge jisse time complexity O(N) me ho jayega
            */
            // for(int j = 0; j < windowSize; j++){
            //    ans[j] = Math.max(ans[j] , arr[i]);
            // }
          ans[windowSize - 1] = Math.max(ans[windowSize - 1] , arr[i]);
         }
         
         for(int i = n - 1; i > 0; i--){
            ans[i - 1] = Math.max(ans[i - 1], ans[i]);
         } 
         return ans;

     }
     void dis(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }
}


public class MaximumOfMinEveryWindowSizeM3{
    public static void main(String[] args) {
        
        Solution obj = new Solution();

        int[] arr = {10, 20, 15, 50, 10, 70 , 30};
          
        int[] ans = obj.maxOfMins(arr);

        obj.dis(arr);
        obj.dis(ans);

    }
}
