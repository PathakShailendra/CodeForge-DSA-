package LinkedList;

public class SortLLOs1s2s {
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    public  Node segregate(Node head) {
        // add your code here
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0)zeros++;
            else if(temp.data == 1)ones++;
            else twos++;
            temp = temp.next;
        }
        Node dummy = new Node(-1);
        temp = dummy;
        while(zeros-- != 0) {
            temp.next = new Node(0);
            temp = temp.next;
        }
        while(ones-- != 0) {
            temp.next = new Node(1);
            temp = temp.next;
        }
        while(twos-- != 0) {
            temp.next = new Node(2);
            temp = temp.next;
        }
        return dummy.next;
    }
}
