import java.util.Arrays;

public class _395_LongestSubstring {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (int curKind = 1; curKind <= 26; curKind++) {
            Arrays.fill(cnt, 0);
            int left = 0, right = 0;
            // totalKind:窗口内所有字符类型的数量，sumKind:窗口内满足出现次数不小于k的字符类型数量
            int totalKind = 0, sumKind = 0;
            while (right < len) {
                int rightIndex = chars[right] - 'a';
                cnt[rightIndex]++;
                if (cnt[rightIndex] == 1) totalKind++;
                if (cnt[rightIndex] == k) sumKind++;
                while (totalKind > curKind) {
                    int leftIndex = chars[left] - 'a';
                    if (cnt[leftIndex] == 1) totalKind--;
                    if (cnt[leftIndex] == k) sumKind--;
                    cnt[leftIndex]--;
                    left++;
                }
                if (totalKind == sumKind) res = Math.max(res, right - left + 1);
                right++;
            }
        }
        return res;
    }
}
