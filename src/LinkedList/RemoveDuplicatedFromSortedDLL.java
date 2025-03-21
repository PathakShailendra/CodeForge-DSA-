package LinkedList;

public class RemoveDuplicatedFromSortedDLL {
    class Node
    {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                Node nextNode = temp.next.next;
                temp.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
