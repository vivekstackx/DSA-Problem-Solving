/*

Dono ka inorder traversal → O(n + m)
Merge → O(n + m)
Lists + answer → O(n + m) space

So:

Time: O(n + m)
Extra Space: O(n + m)

*/


/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
} */

class Solution {
    
    private void inorder(Node root , List<Integer> list){
      
       if(root == null) return;
       
       inorder(root.left , list);
       list.add(root.data);
       inorder(root.right , list);
       
    }
    
    public ArrayList<Integer> merge(Node r1, Node r2) {
        // code here
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        inorder(r1 , list1);
        inorder(r2 , list2);
        
        int i = 0;
        int j = 0;
        
        while(i < list1.size() && j < list2.size()){
            
            int list1Data = list1.get(i);
            int list2Data = list2.get(j);
            
            if(list1Data == list2Data){
                ans.add(list1Data);
                ans.add(list2Data);
                i++;
                j++;
            }
            else if(list1Data < list2Data){
                ans.add(list1Data);
                i++;
            }
            else{
                ans.add(list2Data);
                j++;
            }
            
        }
        
        while(i < list1.size()){
            ans.add(list1.get(i));
            i++;
        }
        
        while(j < list2.size()){
            ans.add(list2.get(j));
            j++;
        }
        
        return ans;
    }
}
