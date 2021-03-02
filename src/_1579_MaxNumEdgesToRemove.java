import java.util.Arrays;

public class _1579_MaxNumEdgesToRemove {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unionFind1 = new UnionFind(n);
        UnionFind unionFind2 = new UnionFind(n);
        int ans = 0;

        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!unionFind1.union(edge[1], edge[2])) {
                    ans++;
                } else {
                    unionFind2.union(edge[1], edge[2]);
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!unionFind1.union(edge[1], edge[2])) {
                    ans++;
                }
            } else if (edge[0] == 2) {
                if (!unionFind2.union(edge[1], edge[2])) {
                    ans++;
                }
            }
        }

        if (unionFind1.setCount != 1 || unionFind2.setCount != 1) {
            return -1;
        }

        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        int setCount;

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

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            setCount--;
            return true;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
