package LinkedList;

public class DeleteMiddleOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)return null;
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int mid = size/2;
        int i = 1;
        temp = head;
        while(i < mid) {
            temp = temp.next;
            i++;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
    }
}
