package Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Pair P2) {
            return this.freq - P2.freq;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(var e : map.entrySet()) {
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            for(int i = 0; i < curr.freq; i++) {
                sb.append(curr.ch);
            }
        }
        return sb.toString();
    }
}
