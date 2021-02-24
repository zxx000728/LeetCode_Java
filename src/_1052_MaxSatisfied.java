import java.util.Map;

public class _1052_MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int left = 0, right = 0;
        int maxNum = 0;
        int tmp = 0;
        int extra = 0;
        while (right < len) {
            maxNum += (1 - grumpy[right]) * customers[right];
            tmp += grumpy[right] * customers[right++];
            if (right - left == X) {
                extra = Math.max(extra, tmp);
                tmp -= grumpy[left] * customers[left++];
            }
        }
        return maxNum + extra;
    }
}
