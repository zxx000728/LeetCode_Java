public class _567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count = new int[26];
        // initial
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int c : count) {
            if (c != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - len1) - 'a';
            if (x == y) {
                continue;
            }
            if (count[x] == 0) {
                diff++;
            }
            count[x]++;
            if (count[x] == 0) {
                diff--;
            }
            if (count[y] == 0) {
                diff++;
            }
            count[y]--;
            if (count[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}
