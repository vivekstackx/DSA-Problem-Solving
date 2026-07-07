
/*
Mera Observation:

Maine notice kiya ki maan lo first list ki length 7 hai aur second list ki length 5 hai.
Ab agar ek pointer first list par aur doosra pointer second list par ho, aur dono ko
ek-ek step move karte chalein, to second list wala pointer pehle null ho jayega,
kyunki uski length chhoti hai.

Yahi par maine ek interesting baat notice ki.

Jab second pointer null hota hai, us samay first pointer ke paas abhi bhi 2 nodes
(6 aur 7) bache hote hain. Yani dono pointers ke beech 2 nodes ka difference aa jata hai.

Agar hame intersection node tak pahunchna hai, to dono pointers ko intersection node
ke hisaab se same level par lana hoga. Is 2 nodes ke difference ko remove karna zaroori hai.

Isi liye jab second pointer null hota hai, use first list ke head par dobara nahi bhejte,
balki second pointer ko first list ke head ki jagah doosri list ke opposite head par
(headA ↔ headB) bhej dete hain.

Ab jab dono pointers aage move karte hain, kuch steps baad first pointer bhi null ho jata hai.
Tab tak second pointer wahi extra 2 nodes cover kar chuka hota hai. Phir first pointer ko
second list ke head par bhej dete hain.

Is process ki wajah se dono lists ke length ka difference automatically cancel ho jata hai,
aur dono pointers intersection node ke respect me same level par aa jate hain.
Isi wajah se dono pointers exactly intersection node par milte hain.

Ek aur observation:

Jab first pointer null hota hai to use first list ke head par dobara nahi bhejte,
balki second list ke head par bhejte hain. Aur jab second pointer null hota hai,
to use second list ke head par nahi, balki first list ke head par bhejte hain.

Reason bahut simple hai.

Hame dono pointers ke beech jo length difference hai, use automatically remove karna hota hai.
Agar pointer ko apni hi list ke head par bhej denge, to difference kabhi khatam nahi hoga.

Isliye first pointer ko second list aur second pointer ko first list par bhejte hain,
taaki dono lists ka length difference automatically adjust ho jaye aur dono pointers
intersection node ke respect me equal level par pahunch saken.
*/

  
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
          ListNode curr1 = headA;
          ListNode curr2 = headB;

          while(curr1 != curr2){
             
              if(curr1 == null){
                 curr1 = headB;
              }
              else {
                 curr1 = curr1.next;
              }

              if(curr2 == null){
                 curr2 = headA;
              }
              else{
                 curr2 = curr2.next;
              }
          }

          return curr1;
    }
}

/*
My Observation:

I noticed that suppose the length of the first linked list is 7 and the length of the
second linked list is 5.

Now, if one pointer starts from the first list and the other pointer starts from the
second list, and both pointers move one step at a time, then the pointer of the second
list will reach null first because its length is smaller.

Here I noticed an interesting observation.

When the second pointer becomes null, the first pointer still has 2 nodes (6 and 7)
remaining. In other words, there is a difference of 2 nodes between the two pointers.

If we want both pointers to meet at the intersection node, they must be at the same
relative level with respect to the intersection. Therefore, this difference of 2 nodes
must be eliminated.

This is why, when the second pointer becomes null, we do not move it back to the head
of its own list. Instead, we redirect it to the head of the other linked list.

After both pointers continue moving, the first pointer also eventually becomes null.
By that time, the second pointer has already covered those extra 2 nodes. Then we
redirect the first pointer to the head of the second list.

As a result, the length difference between the two linked lists is automatically
eliminated, and both pointers become aligned at the same relative level with respect
to the intersection node. This is why they eventually meet exactly at the intersection
node.

Another observation:

When the first pointer becomes null, we redirect it to the head of the second list,
not back to the head of the first list. Similarly, when the second pointer becomes
null, we redirect it to the head of the first list instead of its own list.

The reason is very simple.

Our goal is to eliminate the length difference between the two linked lists.
If each pointer is redirected back to its own list, this difference will never disappear.

Therefore, the first pointer is redirected to the second list, and the second pointer
is redirected to the first list. This automatically compensates for the length
difference and allows both pointers to reach the same relative level, where they
eventually meet at the intersection node.
*/
