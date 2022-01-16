/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _123_MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0];  // 在某天结束后只进行过一次买时的最大利润
        int sell1 = 0;          // 在某天结束后进行过一次买一次卖，完成了一次交易时的最大利润
        int buy2 = -prices[0];  // 在某天结束后进行过一次交易+一次买时的最大利润
        int sell2 = 0;          // 在某天结束后完成了两次交易时的最大利润
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
