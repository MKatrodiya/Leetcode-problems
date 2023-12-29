public class BestTimeToBuySellStock2 {
  public int maxProfit(int[] prices) {
    int i = 0, j;
    int maxP = 0;
    while (i < prices.length) {
      j = i;
      while ((j + 1) < prices.length && prices[j + 1] >= prices[j]) {
        j++;
      }
      if (prices[j] >= prices[i]) {
        maxP += prices[j] - prices[i];
      }
      i = j + 1;
    }
    return maxP;
  }
}
