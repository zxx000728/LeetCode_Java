public class _121_MaxProfit {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(min, price);
        }
        return maxProfit;
    }
}
