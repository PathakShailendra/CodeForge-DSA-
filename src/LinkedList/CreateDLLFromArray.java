package LinkedList;

public class CreateDLLFromArray {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int x) {
            this.data = x;
            prev = null;
            next = null;
        }
    }
    Node constructDLL(int arr[]) {
        // Code here
        Node head = new Node(arr[0]);
        Node temp = head;
        int i = 1;
        while(i < arr.length) {
            Node newNode = new Node(arr[i++]);
            newNode.prev = temp;
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
}
