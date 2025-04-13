package HeapsAndPriorityQueue;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqMap.values()) {
            maxHeap.offer(freq);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            int tasksDone = 0;
            for (int i = 0; i < cycle && !maxHeap.isEmpty(); i++) {
                int freq = maxHeap.poll();
                if (freq - 1 > 0) {
                    temp.add(freq - 1);
                }
                tasksDone++;
            }

            for (int remainingFreq : temp) {
                maxHeap.offer(remainingFreq);
            }

            time += maxHeap.isEmpty() ? tasksDone : cycle;
        }

        return time;
    }
}
