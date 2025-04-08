package LinkedList;

import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node){
        Node temp = head.next;

        node.next = temp;
        node.prev = head;

        head.next = node;
        temp.prev = node;
    }

    private void deleteNode(Node node){
        Node prevv = node.prev;
        Node nextt = node.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            int value = curr.val;

            map.remove(key);
            deleteNode(curr);
            addNode(curr);

            map.put(key, head.next);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }
        if(map.size() == capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */