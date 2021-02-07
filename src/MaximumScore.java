import java.util.Arrays;

public class MaximumScore {
    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int min = arr[0];
        int mid = arr[1];
        int max = arr[2];
        int delta = max - mid;
        if (min <= delta) {
            return min + mid;
        } else {
            int remain = min - delta;
            if ((remain & 1) == 1) {
                return min + mid - remain / 2- 1;
            } else {
                return min + mid - remain / 2;
            }
        }
    }
}
