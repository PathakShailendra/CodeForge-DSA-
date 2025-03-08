package LinkedList;

public class SearchInLinkedList {

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
     boolean searchKey(int n, Node head, int key) {
        // Code here
        for(int i = 0; i < n; i++) {
            if(head.data == key)return true;
            head = head.next;
        }
        return false;
    }
}
