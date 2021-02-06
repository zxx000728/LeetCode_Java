public class _643_FindMaxAverage {
//    public double findMaxAverage(int[] nums, int k) {
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if (i >= k) {
//                sum = sum - nums[i - k];
//            }
//            if (i >= k - 1) {
//                max = Math.max(sum, max);
//            }
//        }
//        return 1.0 * max / k;
//    }

    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int[] preSum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = k - 1; i < length; i++) {
            max = Math.max(preSum[i + 1] - preSum[i + 1 - k], max);
        }
        return 1.0 * max / k;
    }
}
