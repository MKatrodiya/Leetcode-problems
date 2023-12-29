import java.util.Stack;

public class BestTimeToBuySellStock {
  public int maxProfit(int[] prices) {
    int[] highestToRight = new int[prices.length];
    int max = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      if (max > prices[i]) {
        highestToRight[i] = max;
      }
      max = Math.max(max, prices[i]);
    }
    max = 0;
    for (int i = 0; i < prices.length; i++) {
      max = Math.max(max, highestToRight[i] - prices[i]);
    }
    return max;
  }
}
