import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> setA = new HashSet<>();
        for (int a : A) {
            setA.add(a);
        }
        for (int y : B) {
            int x = y + delta;
            if (setA.contains(x)) {
                result[0] = x;
                result[1] = y;
                break;
            }
        }
        return result;
    }
}
