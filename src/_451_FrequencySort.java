import java.util.*;

public class _451_FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder ret = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            int i = entry.getValue();
            char key = entry.getKey();
            for (int j = 0; j < i; j++) {
                ret.append(key);
            }
        }
        return ret.toString();
    }
}
