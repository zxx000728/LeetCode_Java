import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1489_FindCriticalAndPseudoCriticalEdges {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        UnionFind unionFind = new UnionFind(n);
        int value = 0;
        for (int i = 0; i < m; i++) {
            if (unionFind.unite(newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            UnionFind unionFind1 = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && unionFind1.unite(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (unionFind1.setCount != 1 || (unionFind1.setCount == 1 && v > value)) {
                ans.get(0).add(newEdges[i][3]);
                continue;
            }
            unionFind1 = new UnionFind(n);
            unionFind1.unite(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; j++) {
                if (i != j && unionFind1.unite(newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                ans.get(1).add(newEdges[i][3]);
            }
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

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            int rootX = findset(x);
            int rootY = findset(y);
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

        public boolean connected(int x, int y) {
            return findset(x) == findset(y);
        }

    }
}
