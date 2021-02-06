public class _424_CharacterReplacement {
    private int[] map = new int[26]; // 当前子串中各字母的个数

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]); // 窗口扩张
            if (right - left + 1 > historyCharMax + k) { // 当前子串不满足，滑动窗口
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
