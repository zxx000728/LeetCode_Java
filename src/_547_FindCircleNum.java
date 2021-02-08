public class _547_FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.unionElement(i, j);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int element) {
            while (element != parent[element]) {
                element = parent[element];
            }
            return element;
        }

        public void unionElement(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return;
            }
            parent[firstRoot] = secondRoot;
            this.count--;
        }
    }
}
