class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
   
    // Helper to insert at the beginning of the result list
    private Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode; // Becomes the new head
    }

    // Helper to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addTwoSum(Node list1, Node list2) {
        // Reverse both lists to start adding from the least significant digit (units place)
        list1 = reverse(list1);
        list2 = reverse(list2);

        Node curr1 = list1;
        Node curr2 = list2;
        Node resultList = null;
        int carry = 0;

        // A single, elegant loop handles all cases (both lists, or either list, or remaining carry)
        while (curr1 != null || curr2 != null || carry != 0) {
            int sum = carry;

            if (curr1 != null) {
                sum += curr1.data;
                curr1 = curr1.next;
            }

            if (curr2 != null) {
                sum += curr2.data;
                curr2 = curr2.next;
            }

            // Calculate new carry and the digit to store
            carry = sum / 10;
            int digit = sum % 10;

            resultList = insertAtBeginning(resultList, digit);
        }

        return resultList;
    }

    // Utility method to display the list
    void dis(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // List 1: 5 -> 4 -> 9 -> 8  (5498)
        Node list1 = new Node(5);
        list1.next = new Node(4);
        list1.next.next = new Node(9);
        list1.next.next.next = new Node(8);

        // List 2: 3 -> 7 -> 2 -> 6 -> 1  (37261)
        Node list2 = new Node(3);
        list2.next = new Node(7);
        list2.next.next = new Node(2);
        list2.next.next.next = new Node(6);
        list2.next.next.next.next = new Node(1);

        Solution sol = new Solution();
        Node newList = sol.addTwoSum(list1, list2);

        // Expected Output: 4 2 7 5 9  (5498 + 37261 = 42759)
        sol.dis(newList); 
    }
}
