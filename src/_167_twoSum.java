public class _167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int res;
        while (left < right) {
            res = numbers[left] + numbers[right];
            if (res == target)
                return new int[]{left + 1, right + 1};
            else if (res < target)
                left++;
            else right--;
        }
        return null;
    }
}
