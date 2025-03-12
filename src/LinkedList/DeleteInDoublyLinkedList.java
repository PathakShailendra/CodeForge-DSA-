package LinkedList;

public class DeleteInDoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    public Node deleteNode(Node head, int x) {
        if (head == null) return null;
        if (x == 1) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < x) {
            temp = temp.next;
            count++;
        }
        if (temp == null) return head;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        return head;
    }
}