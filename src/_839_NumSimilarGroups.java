public class _839_NumSimilarGroups {
    int[] parent;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = find(i);
                int y = find(j);
                if (x == y) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    parent[x] = y;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
