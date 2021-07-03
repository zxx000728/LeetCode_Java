public class _477_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            res += c * (n - c);
        }
        return res;
    }
}
