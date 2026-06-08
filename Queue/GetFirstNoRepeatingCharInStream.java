class Solution{
    // funciton to check a character is dublicate or not 
     private boolean isRepeate(String stream , char ch , int index){
        int n = stream.length();

        for(int i = 0; i < n; i++){
            if(stream.charAt(i) == ch && i != index){
              return true;
            }
        }
        return false;
     }
   // function to get no repeating character in stream
   private char getNoRepeatingStream(String stream){
        int n = stream.length();

        for(int i = 0; i < n; i++){
            if(!isRepeate(stream , stream.charAt(i) , i)){
              return stream.charAt(i);
            }
        }
        return '#';
    }
    
    // function to get the first no repeating character in stream 
       String getFirstNoRepeatingChar(String str){
          
           int n = str.length();
           String stream = "";
           String ans = "";

           for(int i = 0; i < n; i++){
                stream = stream + str.charAt(i);
                char ch = getNoRepeatingStream(stream);
                ans = ans + ch;
           }
           return ans;
       }
}

public class GetFirstNoRepeatingCharInStream {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String str = "abcacdbd";

        String ans = obj.getFirstNoRepeatingChar(str);
        System.out.println(ans);
    }
}
