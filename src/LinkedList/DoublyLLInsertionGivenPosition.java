package LinkedList;

public class DoublyLLInsertionGivenPosition {
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
    Node addNode(Node head, int p, int x) {
        Node newNode = new Node(x);
        if(head==null){
            return newNode;
        }
        Node temp=head;
        int count = 0;

        while(temp!=null && count<p){
            temp = temp.next;
            count++;
        }
        if(temp==null){
            return head;
        }
        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp.next != null){
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        return head;
    }
}