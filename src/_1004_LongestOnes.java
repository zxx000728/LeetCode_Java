public class _1004_LongestOnes {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        int maxLen = 0;
        int count = 0;
        while (right < len) {
            if (A[right] == 0) {
                count++;
            }
            while (count > K) {
                if (A[left++] == 0) {
                    count--;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
