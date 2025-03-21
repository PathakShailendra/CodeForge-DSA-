package LinkedList;

public class AddOneToLinkedListNumber {
    class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }
    public Node addOne(Node head) {
        head = reverse(head);

        Node temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data += carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            }
            temp.data = 0;
            if (temp.next == null) {
                temp.next = new Node(1);
                carry = 0;
            }
            temp = temp.next;
        }


        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
