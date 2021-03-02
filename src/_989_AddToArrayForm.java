import java.util.ArrayList;
import java.util.List;

public class _989_AddToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List<Integer> ans = new ArrayList<>();
        int i = n - 1, sum = 0, carry = 0;
        while (i >= 0 || K != 0) {
            int x = i >= 0 ? A[i] : 0;
            int y = K != 0 ? K % 10 : 0;
            sum = x + y + carry;
            carry = sum / 10;
            K = K / 10;
            i--;
            ans.add(0, sum % 10);
        }
        if (carry != 0) {
            ans.add(0, carry);
        }
        return ans;
    }
}
