public class _1332_RemovePalindromeSub {
    public int removePalindromeSub(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return 2;
        }
        return 1;
    }
}
