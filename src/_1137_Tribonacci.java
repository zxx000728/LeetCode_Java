public class _1137_Tribonacci {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int first = 0, second = 1, third = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = first + second + third;
            first = second;
            second = third;
            third = res;
        }
        return res;
    }
}
