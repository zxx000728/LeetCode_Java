import java.util.ArrayList;

public class _992_SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        int count = 0;
        int result = 0;
        int[] freq = new int[len + 1];
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;
            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            result += right - left;
        }
        return result;
    }
}
