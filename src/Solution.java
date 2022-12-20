import java.util.Arrays;

class Solution {
    public static int maxProfit(int[] prices) {

        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                total += profit;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}