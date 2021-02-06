import java.util.Arrays;

public class _628_MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }
}
