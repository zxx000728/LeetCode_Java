import java.util.*;

public class _692_topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
                new PriorityQueue<>((o1, o2) ->
                        o1.getValue().equals(o2.getValue()) ?
                                o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}
