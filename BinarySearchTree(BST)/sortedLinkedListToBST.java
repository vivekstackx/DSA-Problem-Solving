/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}

//Tree Node
class TNode
{ 
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}*/

class Solution {
    
    private TNode helper(int[] arr , int start , int end){
    
        if(start > end) return null;
        
        int mid = (start + end) / 2;
        
        TNode newNode = new TNode(arr[mid]);
        
        newNode.left = helper(arr , start , mid - 1);
        newNode.right = helper(arr , mid + 1 , end);
        
        return newNode;
    }
    
    public TNode sortedListToBST(LNode head) {
        
        LNode curr = head;
        int size = 0;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        int[] arr = new int[size];
        
        curr = head; 
        int i = 0;
        
        while(curr != null){
            arr[i] = curr.data;
            i++;
            curr = curr.next;
        }
        
        int start = 0;
        int end = size - 1;
        
        return helper(arr , start , end );
        
    }
}
