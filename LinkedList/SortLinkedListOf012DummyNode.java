class Solution {
    public Node segregate(Node head) {
        if (head == null) return null;
        
        // 3 Dummy nodes banayein jo starting point ka kaam karenge
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        
        // Tails jo moving pointers honge
        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;
        
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }
        
        // Teeno lists ko aapas mein chain ki tarah jod dein
        // Agar 1s nahi bhi hain, toh oneDummy.next null hoga, jo apne aap handle ho jayega!
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null; // Last node ke next ko hamesha null karein
        
        // Real head zeroDummy ka next hoga
        return zeroDummy.next;
    }
}
