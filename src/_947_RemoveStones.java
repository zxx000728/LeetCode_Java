import java.util.HashMap;
import java.util.Map;

public class _947_RemoveStones {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getSetCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int setCount;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.setCount = 0;
        }

        public int getSetCount() {
            return setCount;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                setCount++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            setCount--;
        }
    }
}
