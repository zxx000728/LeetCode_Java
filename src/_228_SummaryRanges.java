import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        int i = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            if (j + 1 == len || nums[j] + 1 != nums[j + 1]) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nums[i]);
                if (i != j) {
                    stringBuilder.append("->").append(nums[j]);
                }
                res.add(stringBuilder.toString());
                i = j + 1;
            }
        }
        return res;
    }
}
