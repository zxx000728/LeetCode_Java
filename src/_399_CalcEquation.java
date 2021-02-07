import java.util.HashMap;
import java.util.List;

public class _399_CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        HashMap<String, Integer> hashMap = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);
            if (!hashMap.containsKey(val1)) {
                hashMap.put(val1, id);
                id++;
            }
            if (!hashMap.containsKey(val2)) {
                hashMap.put(val2, id);
                id++;
            }
            unionFind.unionElement(hashMap.get(val1), hashMap.get(val2), values[i]);
        }
        int queriesSize = queries.size();
        double[] result = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String val1 = queries.get(i).get(0);
            String val2 = queries.get(i).get(1);
            Integer id1 = hashMap.get(val1);
            Integer id2 = hashMap.get(val2);
            if (id1 == null || id2 == null) {
                result[i] = -1.0d;
            } else {
                result[i] = unionFind.isConnected(id1, id2);
            }
        }
        return result;
    }

    class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.weight = new double[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        int find(int element) {
            if (element != parent[element]) {
                int oldParent = parent[element];
                parent[element] = find(parent[element]);
                weight[element] *= weight[oldParent];
            }
            return parent[element];
        }

        double isConnected(int firstElement, int secondElement) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return weight[firstElement] / weight[secondElement];
            } else {
                return -1.0d;
            }
        }

        void unionElement(int firstElement, int secondElement, double value) {
            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);
            if (firstRoot == secondRoot) {
                return;
            }
            parent[firstRoot] = secondRoot;
            weight[firstRoot] = weight[secondElement] * value / weight[firstElement];
        }
    }
}
