import java.util.Arrays;

public class _561_ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
