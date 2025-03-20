package LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoLL {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp))return temp;
            temp = temp.next;
        }
        return null;

    }
}
