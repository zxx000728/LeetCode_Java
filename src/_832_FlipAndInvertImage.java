import java.util.Arrays;

public class _832_FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for (int[] a : A) {
            int left = 0, right = len - 1;
            for (; left < right; left++, right--) {
                int temp = ~a[left]&1;
                a[left] = ~a[right]&1;
                a[right] = temp;
            }
            a[left] = (len & 1) == 1 ? ~a[left]&1 : a[left];
        }
        return A;
    }
}
