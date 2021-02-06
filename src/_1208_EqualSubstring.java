public class _1208_EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int left = 0, right = 0;
        int sum = 0;
        int maxLength = 0;
        while (right < length) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
