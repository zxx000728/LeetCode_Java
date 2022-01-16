public class _645_FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n];
        int[] ret = new int[2];
        for (int num : nums) {
            if (check[num - 1]) {
                ret[0] = num;
            }
            check[num - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            if (!check[j]) {
                ret[1] = j + 1;
                break;
            }
        }
        return ret;
    }
}
