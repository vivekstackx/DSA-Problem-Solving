/*
 core logic ye h --
 ham jab v compare karte h to hame bas itna dhyan dena h ki do node me sabse chhota node kon sa h 
jo v node chhota hoga uas node ko list ke end me add kr diya jayega (tail ke next me ) or fir tail ko uasi 
node pe point karwa diya jayega , aisa islie kyunki ham bas ek bade node pe wait karte h , tab tak wait karte h 
jab tak o node se bada ko node aa na jaye jab tak uas node se sabhi node chhota hota h , hame uas node ko uas bade 
node se pahle hi jodna hoga 
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while(curr1 != null && curr2!= null){

             if(curr1.data <= curr2.data){
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
             }
             else{
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;
             }
        }
        
       tail.next = curr1 == null ? curr2 : curr1;

       return dummyNode.next; // head

    }
}
