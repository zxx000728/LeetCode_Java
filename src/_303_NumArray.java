public class _303_NumArray {
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            int len = nums.length;
            this.preSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }
}
