import java.util.Arrays;

public class _1423_MaxScore {
    //    public int maxScore(int[] cardPoints, int k) {
//        int length = cardPoints.length;
//        int windowSize = length - k;
//        int sum = 0;
//        for (int i = 0; i < windowSize; i++) {
//            sum += cardPoints[i];
//        }
//        int minSum = sum;
//        for (int i = windowSize; i < length; i++) {
//            sum = sum - cardPoints[i - windowSize] + cardPoints[i];
//            minSum = Math.min(minSum, sum);
//        }
//        return Arrays.stream(cardPoints).sum() - minSum;
//    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] += preSum[i] + cardPoints[i];
        }
        int minSum = Integer.MAX_VALUE;
        int windowSize = n - k;
        for (int i = 0; i < k + 1; i++) {
            minSum = Math.min(minSum, preSum[windowSize + i] - preSum[i]);
        }
        return preSum[n] - minSum;
    }
}
