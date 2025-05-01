package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {



        // Function to return a list of nodes visible from the top view
        // from left to right in Binary Tree.
        static class Info{
            Node node;
            int hd;
            public Info(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        static ArrayList<Integer> topView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            HashMap<Integer, Node> map = new HashMap<>();
            Queue<Info> q = new LinkedList<>();
            int min = 0; int max = 0;
            q.add(new Info(root, 0));
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    Info curr = q.remove();
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new Info(curr.node.left, curr.hd-1));
                        min = Math.min(min, curr.hd-1);
                    }
                    if(curr.node.right != null){
                        q.add(new Info(curr.node.right, curr.hd+1));
                        max = Math.max(max, curr.hd+1);
                    }
                }
            }
            for(int i = min; i <= max;i++){
                ans.add(map.get(i).data);
            }

            return ans;
        }
}
