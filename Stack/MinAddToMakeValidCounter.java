
class Solution {

    public int minAddToMakeValid(String s) {

             int openingBracket = 0;
            int closingBracket = 0;

         for(char ch : s.toCharArray()){
            // opening bracket
             if(ch == '('){
               openingBracket++;
             }
             // closing bracket
             else if(ch == ')'){
                 if(openingBracket == 0){
                    closingBracket++;
                 }
                 else {
                     openingBracket--;
                 }
             }
         }
         return openingBracket + closingBracket;
    }
}
