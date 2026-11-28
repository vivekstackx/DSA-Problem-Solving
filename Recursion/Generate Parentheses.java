class Solution {

    private void generate(int n , int left , int right , List<String> ans , StringBuilder str){
        
             // left parenthesis
             if(left < n){
                str.append('(');
                generate(n , left + 1 , right , ans , str);
             }

             // right parenthesis
             if(right < left){
                str.append(')');
                generate(n , left , right + 1 , ans , str);
             }
            
            // valid perenthesis
             if(left == n && right == n){
                ans.add(str.toString());
             }

             // backtracking
             if(str.length() > 0){
                str.deleteCharAt(str.length() - 1);
             }

    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>(); 

        StringBuilder str = new StringBuilder();

        generate(n , 0 , 0 , ans , str); 
        
        return ans;

    }
}
