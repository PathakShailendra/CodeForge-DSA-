package LinkedList;

public class ReverseNodesInKGroup {

    public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode l = head;
        ListNode r = head;
        int i = k;
        while(i-->0) {
            if (r == null)
                return head;
            r = r.next;
        }

        ListNode ans = rev(l, r);
        l.next = reverseKGroup(r, k);
        return ans;
    }

    public ListNode rev(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
