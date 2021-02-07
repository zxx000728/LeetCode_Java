public class _665_CheckPossibility {
    //    public boolean checkPossibility(int[] nums) {
//        int len = nums.length;
//        int right = 0;
//        int count = 0;
//        while (right < len - 1) {
//            if (nums[right] > nums[right + 1]) {
//                if (right - 1 < 0 || nums[right - 1] <= nums[right + 1]) {
//                    nums[right] = nums[right + 1];
//                } else if (nums[right - 1] > nums[right + 1]) {
//                    nums[right + 1] = nums[right];
//                }
//                count++;
//                if (count > 1) {
//                    return false;
//                }
//            }
//            right++;
//        }
//        return true;
//    }
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
