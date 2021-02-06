import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _1002_CommonChars {
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String s : A) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < minfreq.length; i++) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < minfreq.length; i++) {
            if (minfreq[i] != 0) {
                for (int j = 0; j < minfreq[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return result;
    }
}
