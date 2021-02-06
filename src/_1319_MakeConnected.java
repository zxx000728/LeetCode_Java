import java.util.Arrays;

public class _1319_MakeConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            UnionFind unionFind = new UnionFind(n);
            for (int[] conn : connections) {
                unionFind.unite(conn[0], conn[1]);
            }
            return unionFind.setCount - 1;
        }
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        int setCount; // 当前连通分量数目

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findSet(int x) {
            return parent[x] == x ? x : findSet(parent[x]);
        }

        public boolean unite(int x, int y) {
            x = findSet(x);
            y = findSet(y);
            if (x == y) {
                return false;
            }
            // based on weight
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            setCount--;
            return true;
        }

        public boolean connected(int x, int y) {
            x = findSet(x);
            y = findSet(y);
            return x == y;
        }
    }
}
