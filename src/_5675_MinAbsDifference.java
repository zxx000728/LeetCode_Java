import java.util.Arrays;

public class _5675_MinAbsDifference {
    public int minAbsDifference(int[] nums, int goal) {
        int len = nums.length;
        int leftLen = (len + 1) / 2;
        int rightLen = len - leftLen;
        int[] leftSums = new int[1 << leftLen];
        int[] rightSums = new int[1 << rightLen];
        for (int i = 0; i < leftSums.length; i++) {
            for (int j = 0; j < leftLen; j++) {
                if (((i >> j) & 1) == 1) { // e.g. 101011 每一位代表一个数，该位为1的数相加，计算各种组合
                    leftSums[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < rightSums.length; i++) {
            for (int j = 0; j < rightLen; j++) {
                if (((i >> j) & 1) == 1) {
                    rightSums[i] += nums[leftLen + j];
                }
            }
        }
        Arrays.sort(rightSums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < leftSums.length; i++) {
            int delta = goal - leftSums[i];
            int index = find(rightSums, delta);
            if (index < rightSums.length) {
                result = Math.min(result, Math.abs(leftSums[i] + rightSums[index] - goal));
            }
            if (index - 1 >= 0) {
                result = Math.min(result, Math.abs(leftSums[i] + rightSums[index - 1] - goal));
            }
        }
        return result;
    }

    // find index where num >= delta
    int find(int[] rightSums, int delta) {
        int left = 0, right = rightSums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (rightSums[mid] < delta) {
                left = mid + 1;
            } else if (rightSums[mid] > delta) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
