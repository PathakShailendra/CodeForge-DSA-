package LinkedList;

public class ReverseSinglyLLUsingRecursion {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            // Base case: If the list is empty or has only one node
            if (head == null || head.next == null) {
                return head;
            }

            // Reverse the rest of the list
            ListNode newHead = reverseList(head.next);

            // Reverse current node's pointer
            head.next.next = head;
            head.next = null; // Set previous next to null (to avoid cycle)

            return newHead;
        }
    }

}
