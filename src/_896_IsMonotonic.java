public class _896_IsMonotonic {
    public boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;
        int len = A.length;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] > A[i + 1]) {
                increase = false;
            }
            if (A[i] < A[i + 1]) {
                decrease = false;
            }
        }
        return increase || decrease;
    }
}
