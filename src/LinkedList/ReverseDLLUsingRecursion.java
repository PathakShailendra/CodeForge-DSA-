package LinkedList;

public class ReverseDLLUsingRecursion {
    class DLLNode {
        int data;
        DLLNode next, prev;

        DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public class ReverseDoublyLinkedList {
        public DLLNode reverseDLL(DLLNode head) {
            // Base case: empty list or single node
            if (head == null || head.next == null) return head;

            // Reverse the rest of the list
            DLLNode newHead = reverseDLL(head.next);

            // Swap next and prev
            head.next.prev = head;
            head.next = head.prev;
            head.prev = null; // Last node ka prev null hoga

            return newHead; // New head return
        }
    }

}
