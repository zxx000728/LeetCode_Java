import java.util.*;

public class _1631_MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        edges.sort(Comparator.comparingInt(o -> o[2]));
        UnionFind unionFind = new UnionFind(m * n);
        int result = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int value = edge[2];
            unionFind.unite(x, y);
            if (unionFind.isConnected(0, m * n - 1)) {
                result = value;
                break;
            }
        }
        return result;
    }

    class UnionFind {
        int[] parent;
        int[] weight;
        int size;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            this.weight = new int[size];
            Arrays.fill(weight, 1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int element) {
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        public boolean unite(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return false;
            }
            if (weight[firstRoot] < weight[secondRoot]) {
                int temp = firstRoot;
                firstRoot = secondRoot;
                secondRoot = temp;
            }
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
            return true;
        }
    }
}
