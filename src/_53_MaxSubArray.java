/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class _53_MaxSubArray {
    /**
     * 用f(i)表示第i个数结尾的连续子数组的最大和，所求即为f(i)的最大值
     * 求f(i)有两种情况，1是第i个数加入f(i-1)对应的那段，2是第i个数单独开始一段
     * f(i) = max{f(i-1)+nums[i],nums[i]}
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
