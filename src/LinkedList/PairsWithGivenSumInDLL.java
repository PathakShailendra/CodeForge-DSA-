package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithGivenSumInDLL {

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
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node start = head;
        Node end = head;


        while (end.next != null) {
            end = end.next;
        }


        while (start != null && end != null && start != end && start.prev != end) {
            int sum = start.data + end.data;
            if (sum == target) {
                ans.add(new ArrayList<>(Arrays.asList(start.data, end.data)));
                start = start.next;
                end = end.prev;
            } else if (sum < target) {
                start = start.next;
            } else {
                end = end.prev;
            }
        }

        return ans;
    }
}

