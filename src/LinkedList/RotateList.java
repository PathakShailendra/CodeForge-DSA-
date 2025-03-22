package LinkedList;

public class RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode temp = head;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0)return head;
        k = size-k;
        ListNode hold = head;
        while(k-- > 1){
            hold = hold.next;
        }
        temp.next = head;
        head = hold.next;
        hold.next = null;
        return head;
    }
}
