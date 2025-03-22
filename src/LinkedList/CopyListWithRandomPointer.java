package LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node dummy = new Node(temp.val);
            map.put(temp, dummy);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node dummy = map.get(temp);
            dummy.next = map.get(temp.next);
            dummy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
