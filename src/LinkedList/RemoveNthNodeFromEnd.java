package LinkedList;

public class RemoveNthNodeFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(n == size){
            return head.next;
        }

        int index = size-n;
        ListNode curr = head;
        int i = 1;
        while(i < index){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }
}
