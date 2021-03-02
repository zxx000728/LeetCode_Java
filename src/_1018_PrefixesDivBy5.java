import java.util.ArrayList;
import java.util.List;

public class _1018_PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int len = A.length;
        int value = 0;
        for (int i = 0; i < len; i++) {
            value = ((value << 1) + A[i]) % 5;
            res.add(value == 0);
        }
        return res;
    }
}
