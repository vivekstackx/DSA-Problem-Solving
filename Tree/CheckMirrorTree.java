class Solution {
    boolean areMirror(Node a, Node b) {
        // Your code here
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.data != b.data){
            return false;
        }
        boolean left = areMirror(a.left , b.right);
        if(left == false) return false;
        boolean right = areMirror(a.right , b.left);
        if(right == false) return false;
        
        return left && right;
    }
}
