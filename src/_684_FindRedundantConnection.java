public class _684_FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len);
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (unionFind.isConnected(edges[i][0] - 1, edges[i][1] - 1)) {
                result = i;
            } else {
                unionFind.union(edges[i][0] - 1, edges[i][1] - 1);
            }
        }
        return edges[result];
    }

    class UnionFind {
        int[] parent;
        int[] weight;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
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

        public void union(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return;
            }
            if (weight[firstRoot] > weight[secondRoot]) {
                parent[secondRoot] = firstRoot;
                weight[firstRoot] += weight[secondRoot];
            } else {
                parent[firstRoot] = secondRoot;
                weight[secondRoot] += weight[firstRoot];
            }
        }
    }
}
