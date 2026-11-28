class Solution {

    private void generate(int n, int left, int right, List<String> ans, StringBuilder str) {
        
        if (left == n && right == n) {
            ans.add(str.toString());
            return;
        }

        if (left < n) {
            str.append('(');
            generate(n, left + 1, right, ans, str);
            str.deleteCharAt(str.length() - 1);
        }

        if (right < left) {
            str.append(')');
            generate(n, left, right + 1, ans, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, 0, 0, ans, new StringBuilder());
        return ans;
    }
}
