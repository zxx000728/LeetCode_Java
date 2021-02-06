import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_LargeGroupPositions {
    //    public List<List<Integer>> largeGroupPositions(String s) {
//        char[] chars = s.toCharArray();
//        List<List<Integer>> result = new ArrayList<>();
//        int i = 0, j = 0;
//        int n = chars.length;
//        int maxLength = 0;
//        while (j < n) {
//            if (chars[i] == chars[j]) {
//                maxLength++;
//                j++;
//                if (j == n && maxLength >= 3) {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(i);
//                    temp.add(j - 1);
//                    result.add(temp);
//                }
//                continue;
//            } else if (maxLength >= 3) {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(i);
//                temp.add(j - 1);
//                result.add(temp);
//            }
//            maxLength = 0;
//            i = j;
//        }
//        return result;
//    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
