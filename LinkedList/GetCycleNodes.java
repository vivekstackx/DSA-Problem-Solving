import java.util.ArrayList;
import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Returns all nodes that are part of the cycle.
    ArrayList<Integer> getCycleNodes(Node head) {

        HashSet<Node> visited = new HashSet<>();
        Node current = head;

        // Traverse the linked list until a visited node is found.
        while (current != null) {

            if (visited.contains(current)) {
                break;
            }

            visited.add(current);
            current = current.next;
        }

        // No cycle found.
        if (current == null) {
            return new ArrayList<>();
        }

        Node cycleStartNode = current;
        ArrayList<Integer> cycleNodes = new ArrayList<>();

        // Traverse the complete cycle exactly once.
        do {
            cycleNodes.add(current.data);
            current = current.next;
        } while (current != cycleStartNode);

        return cycleNodes;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next; // Create cycle: 6 -> 3

        System.out.println(solution.getCycleNodes(head));
    }
}
