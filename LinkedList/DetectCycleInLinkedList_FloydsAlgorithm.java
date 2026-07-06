/*
 * Agar algorithm safely implement kiya jaye (yaani required null checks kiye jayein), to 
 fast pointer ko 2 se zyada steps chalane par bhi cycle detect ki ja sakti hai. 
 Lekin Floyd's Algorithm me 2-step version isliye use hota hai kyunki woh sabse simple,
 readable aur well-proven hai.
 
 * Algorithm Name:
 * Floyd's Cycle Detection Algorithm
 * (Also known as the Tortoise and Hare Algorithm)
 */

/*
 * मेरी Observation:
 *
 * मान लो किसी Linked List में एक Cycle मौजूद है।
 *
 * शुरुआत में Slow Pointer और Fast Pointer दोनों Head से एक ही Location पर
 * Start करते हैं। इसलिए दोनों के बीच की दूरी (Distance) 0 होती है।
 *
 * अब हर Iteration में:
 * - Slow Pointer 1 Step आगे बढ़ता है।
 * - Fast Pointer 2 Step आगे बढ़ता है।
 *
 * इसलिए दोनों के बीच की दूरी लगातार बढ़ती रहती है:
 *
 * 0, 1, 2, 3, 4, 5, ...
 *
 * -----------------------------------------------------------------
 * अब केवल Cycle के बारे में सोचते हैं।
 * -----------------------------------------------------------------
 *
 * मान लो Cycle की Length 6 है।
 *
 * अगर Slow और Fast Pointer दोनों Cycle के किसी एक ही Node से Start करें,
 * तो उनका Meeting Point हमेशा वही Node होगा जहाँ से उन्होंने Start किया था।
 *
 * मेरा Reason यह है कि जब दोनों एक ही Node पर होते हैं,
 * तब Slow से Fast की दूरी 0 होती है,
 * लेकिन Fast से Slow की दूरी Cycle की पूरी Length के बराबर होती है।
 *
 * उदाहरण:
 *
 * Cycle Length = 6
 *
 * Fast से Slow की दूरी:
 *
 * 6 → 5 → 4 → 3 → 2 → 1 → 0
 *
 * क्योंकि Slow हर बार 1 Step चलता है और Fast हर बार उससे 1 Extra Step
 * आगे निकलता है, इसलिए यह दूरी हर Iteration में 1 कम होती जाती है।
 *
 * जैसे ही यह दूरी 0 हो जाती है, दोनों फिर उसी Node पर मिल जाते हैं
 * जहाँ से उन्होंने Start किया था।
 *
 * -----------------------------------------------------------------
 * अगला Observation
 * -----------------------------------------------------------------
 *
 * अब मान लो Slow और Fast एक ही Node से Start नहीं करते।
 *
 * बल्कि Fast Pointer, Slow Pointer से पहले से ही k Steps आगे है।
 *
 * मेरा Observation यह है कि अगर Fast, Slow से k Steps आगे से Start करे,
 * तो उनका Meeting Point Start Node से k Steps पीछे होगा
 * (Cycle के अनुसार Move करने पर)।
 *
 * यानी Fast जितना आगे होगा,
 * Meeting Point उतना ही पीछे Shift हो जाएगा।
 *
 * -----------------------------------------------------------------
 * Final Observation
 * -----------------------------------------------------------------
 *
 * इसी Observation के आधार पर मुझे लगा कि:
 *
 * Head से Cycle के Starting Node तक की दूरी
 * =
 * Meeting Point से Cycle के Starting Node तक की दूरी
 *
 * इसलिए जब एक Pointer को Head से और दूसरे Pointer को Meeting Point से
 * एक-एक Step आगे बढ़ाते हैं, तो दोनों हमेशा Cycle के Starting Node पर
 * आकर मिलते हैं।
 *
 * यह मेरी Personal Understanding है, जो मैंने लगातार Dry Run और Pattern
 * Observe करके बनाई है।
 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Detects whether the linked list contains a cycle.
    boolean isCycle(Node head) {

        // Initially, both pointers start from the head.
        Node slowPointer = head;
        Node fastPointer = head;

        // Continue until the fast pointer reaches the end of the list.
        while (fastPointer != null && fastPointer.next != null) {

            // Move slow pointer by one step.
            slowPointer = slowPointer.next;

            // Move fast pointer by two steps.
            fastPointer = fastPointer.next.next;

            // If both pointers meet, a cycle exists.
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        // Fast pointer reached the end, so no cycle exists.
        return false;
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
        head.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        // Creates a cycle: 10 -> 4
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;

        System.out.println(solution.isCycle(head));
    }
}

/*
 * My Observation:
 *
 * Suppose a linked list contains a cycle.
 *
 * Initially, both the slow pointer and the fast pointer start from the same
 * location (the head node). Since they start together, the distance between
 * them is 0.
 *
 * After each iteration:
 * - Slow moves 1 step.
 * - Fast moves 2 steps.
 *
 * Therefore, the distance between slow and fast keeps increasing like:
 *
 * 0, 1, 2, 3, 4, 5, ...
 *
 * ------------------------------------------------------------
 * Now let's think only about the cycle.
 * ------------------------------------------------------------
 *
 * Assume the cycle contains 6 nodes.
 *
 * If both slow and fast start from the SAME node inside the cycle,
 * then they will always meet again at that same starting node.
 *
 * Reason:
 *
 * At the starting position:
 *
 * Slow -> Start Node
 * Fast -> Start Node
 *
 * The distance from Slow to Fast is 0.
 *
 * But if we measure the distance from Fast back to Slow while moving
 * forward inside the cycle, the distance is equal to the cycle length.
 *
 * Example:
 *
 * Cycle Length = 6
 *
 * Fast → Slow distance:
 *
 * 6 → 5 → 4 → 3 → 2 → 1 → 0
 *
 * As Slow moves one step and Fast gains one extra step every iteration,
 * this remaining distance decreases by one each time.
 *
 * When this distance becomes 0, both pointers meet exactly at the node
 * from which they originally started.
 *
 * ------------------------------------------------------------
 * Next Observation
 * ------------------------------------------------------------
 *
 * Now suppose Fast does NOT start from the same node.
 *
 * Instead, Fast is already k steps ahead of Slow inside the cycle.
 *
 * Then the meeting point shifts accordingly.
 *
 * Observation:
 *
 * If Fast starts k steps ahead of Slow,
 * then the meeting point will be k steps BEFORE the starting node
 * (while traversing around the cycle).
 *
 * In other words,
 * the more Fast is initially ahead,
 * the same amount the meeting point shifts backward.
 *
 * ------------------------------------------------------------
 * Final Observation
 * ------------------------------------------------------------
 *
 * Because of this property,
 *
 * Distance(Head → Start of Cycle)
 * =
 * Distance(Meeting Point → Start of Cycle)
 *
 * This is the reason why, after detecting the meeting point,
 * moving one pointer from Head and the other from the Meeting Point,
 * one step at a time, makes them meet exactly at the starting node
 * of the cycle.
 */
