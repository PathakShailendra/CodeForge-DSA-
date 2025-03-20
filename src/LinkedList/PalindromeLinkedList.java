package LinkedList;

public class PalindromeLinkedList {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseHalf(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            //update
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;

        ListNode middle = findMiddle(head);
        ListNode reverseIndex = reverseHalf(middle.next);

        ListNode halfStart = head;
        while(reverseIndex != null){
            if(halfStart.val != reverseIndex.val){
                return false;
            }
            halfStart = halfStart.next;
            reverseIndex = reverseIndex.next;
        }
        return true;
    }
}
