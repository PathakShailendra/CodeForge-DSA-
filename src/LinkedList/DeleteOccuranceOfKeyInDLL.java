package LinkedList;

public class DeleteOccuranceOfKeyInDLL {
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }
    public Node deleteAllOccurOfX(Node head, int x) {// Edge case: If the list is empty
        if (head == null) return null;


        Node dummy = new Node(-1);
        dummy.next = head;
        head.prev = dummy;

        Node temp = dummy;


        while (temp.next != null) {
            if (temp.next.data == x) {
                Node nextNode = temp.next.next;
                temp.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = temp;
                } else {
                    temp = temp.next;
                }
            }


        }
        return dummy.next;

    }

}
