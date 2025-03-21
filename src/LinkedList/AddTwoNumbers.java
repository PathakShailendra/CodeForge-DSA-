package LinkedList;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode list1 = new ListNode();
        ListNode list = list1;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            list.next = new ListNode(sum % 10);
            list = list.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            list.next = new ListNode(sum % 10);
            list = list.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            list.next = new ListNode(sum % 10);
            list = list.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            list.next = new ListNode(carry);
        }
        return list1.next;
    }
}
