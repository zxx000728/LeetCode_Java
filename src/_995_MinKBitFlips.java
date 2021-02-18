import java.util.Deque;
import java.util.LinkedList;

public class _995_MinKBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && i > deque.peek() + K - 1) {
                deque.removeFirst();
            }
            if (deque.size() % 2 == A[i]) {
                if (i + K > length)
                    return -1;
                deque.add(i);
                result += 1;
            }
        }
        return result;
    }
}
