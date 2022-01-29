public class _1094_carPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        Difference diff = new Difference(res);
        for (int[] trip : trips) {
            int num = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            diff.increment(i, j, num);
        }
        res = diff.result();
        for (int n : res) {
            if (n > capacity) {
                return false;
            }
        }
        return true;
    }
}
