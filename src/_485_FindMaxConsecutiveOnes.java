public class _485_FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int maxLen = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right] == 0) {
                left = right + 1;
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
