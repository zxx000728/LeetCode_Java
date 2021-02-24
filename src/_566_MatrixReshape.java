import java.util.Arrays;

public class _566_MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldR = nums.length;
        int oldC = nums[0].length;
        if (oldR * oldC != r * c) {
            return nums;
        }
        int[][] ret = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            ret[i / c][i % c] = nums[i / oldC][i % oldC];
        }
        return ret;
    }
}
