import java.util.*;

public class _1203_SortItems {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int len = group.length;
        for (int i = 0; i < len; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        ArrayList<Integer>[] groupAdj = new ArrayList[m];
        ArrayList<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }

        int[] groupsIndegree = new int[m];
        int[] itemsIndegree = new int[n];

        for (int i = 0; i < len; i++) {
            int currentGroup = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                if (beforeGroup != currentGroup) {
                    groupAdj[beforeGroup].add(currentGroup);
                    groupsIndegree[currentGroup]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (Integer item : beforeItems.get(i)) {
                itemAdj[item].add(i);
                itemsIndegree[i]++;
            }
        }

        List<Integer> groupList = topologicalSort(groupAdj, groupsIndegree, m);
        if (groupList.size() == 0) {
            return new int[0];
        }
        List<Integer> itemList = topologicalSort(itemAdj, itemsIndegree, n);
        if (itemList.size() == 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemList) {
            groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        List<Integer> res = new ArrayList<>();
        for (Integer groupId : groupList) {
            List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            res.add(front);
            for (int successor : adj[front]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }

        if (res.size() == n) {
            return res;
        }
        return new ArrayList<>();
    }
}
