public class _1716_TotalMoney {
    public int totalMoney(int n) {
        int week = n / 7;
        int remain = n % 7;
        return ((1 + 7) * 7 / 2) * week + ((week - 1) * week / 2) * 7 + ((week + 1) * 2 + remain - 1) * remain / 2;
    }
}
