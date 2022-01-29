import java.util.HashMap;
import java.util.Map;

public class _560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        int res = 0, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            int tmp = preSum - k;
            if (map.containsKey(tmp))
                res += map.get(tmp);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
