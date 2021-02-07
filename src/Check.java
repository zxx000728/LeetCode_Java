import java.util.Arrays;

public class Check {
    public boolean check(int[] nums) {
        int length = nums.length;
        int[] origin = Arrays.copyOf(nums, length);
        Arrays.sort(origin);
        for (int i = 0; i < length; i++) {
            if (nums[i] > nums[(i + 1) % length] && (nums[i] != origin[length - 1] || nums[(i + 1) % length] != origin[0])) {
                return false;
            }
        }
        return true;
    }
}
