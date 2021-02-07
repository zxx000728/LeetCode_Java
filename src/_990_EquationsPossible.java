public class _990_EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                unionFind.unionElement(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (unionFind.isConnected(s.charAt(0) - 'a', s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFind {
        private int[] parent;
        private int[] weight;
        private int size;

        UnionFind(int size) {
            this.parent = new int[size];
            this.weight = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        int find(int element) {
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        void unionElement(int firstElement, int secondElement) {
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
