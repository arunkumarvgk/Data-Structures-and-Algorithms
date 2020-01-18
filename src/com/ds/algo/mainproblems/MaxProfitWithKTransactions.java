package com.ds.algo.mainproblems;

public class MaxProfitWithKTransactions {

	private static void maxProfit(int prices[], int k) {

		int profits[][] = new int[k][prices.length];

		for (int t = 1; t < k; t++) {
			for (int d = 1; d < prices.length; d++) {

				// Max profit if we dont sell the share on current day
				int previousDayMax = profits[t][d - 1];

				int sellingPrice = prices[d];

				int maxOfBuyingPriceAndPreviousTracProfit = profits[t - 1][0] - prices[0];
				for (int i = 1; i < d; i++) {
					int temp = profits[t - 1][i] - prices[i];
					if (temp > maxOfBuyingPriceAndPreviousTracProfit) {
						maxOfBuyingPriceAndPreviousTracProfit = temp;
					}
				}

				int totalProfitBySellingCurrentDay = sellingPrice + maxOfBuyingPriceAndPreviousTracProfit;
				if (previousDayMax > totalProfitBySellingCurrentDay) {
					profits[t][d] = previousDayMax;
				} else {
					profits[t][d] = totalProfitBySellingCurrentDay;
				}
			}
		}

		System.out.println("Max Profit :: " + profits[k-1][prices.length - 1]);
	}

	private static void maxProfit2(int prices[], int k) {
		int profits[][] = new int[k+1][prices.length];

		for (int t = 1; t < k+1; t++) {
			int maxOfBuyingPriceAndPreviousTracProfit = profits[t - 1][0] - prices[0];
			for (int d = 1; d < prices.length; d++) {

				// Max profit if we dont sell the share on current day
				int previousDayMax = profits[t][d - 1];
				int sellingPrice = prices[d];

				int temp = profits[t - 1][d] - prices[d];
				if (temp > maxOfBuyingPriceAndPreviousTracProfit) {
					maxOfBuyingPriceAndPreviousTracProfit = temp;
				}

				int totalProfitBySellingCurrentDay = sellingPrice + maxOfBuyingPriceAndPreviousTracProfit;
				if (previousDayMax > totalProfitBySellingCurrentDay) {
					profits[t][d] = previousDayMax;
				} else {
					profits[t][d] = totalProfitBySellingCurrentDay;
				}
			}
		}

		System.out.println("Max Profit :: " + profits[k][prices.length - 1]);
	}

	private static void maxProfit3(int prices[], int k) {
		if (prices.length == 0 || prices == null) {
			System.out.println("Max Profit :: 0");
			return;
		}
		int profits[][] = new int[k + 1][prices.length];

		for (int t = 1; t < k + 1; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			for (int d = 1; d < prices.length; d++) {
				maxSoFar = Math.max(maxSoFar, profits[t-1][d-1] - prices[d-1]);
				profits[t][d] = Math.max(maxSoFar + prices[d], profits[t][d-1]);
			}
		}
		
		System.out.println("Max Profit :: " + profits[k][prices.length - 1]);
	}

	// Space n
	private static void maxProfit4(int prices[], int k) {
		if (prices.length == 0 || prices == null) {
			System.out.println("Max Profit :: 0");
			return;
		}
		int evenProfit[] = new int[prices.length];
		int oddProfit[] = new int[prices.length];
		int previousProfit[] = null;
		int currentProfit[] = null;
		
		for (int t = 1; t < k + 1; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			if (t%2 == 0) {
				previousProfit = oddProfit;
				currentProfit = evenProfit;
			} else {
				previousProfit = evenProfit;
				currentProfit = oddProfit;
			}
			for (int d = 1; d < prices.length; d++) {
				maxSoFar = Math.max(maxSoFar, previousProfit[d-1] - prices[d-1]);
				currentProfit[d] = Math.max(maxSoFar + prices[d], currentProfit[d-1]);
			}
		}
		
		System.out.println("Max Profit 4 :: " + currentProfit[prices.length - 1]);
	}
	
	public static void main(String[] args) {

		maxProfit2(new int[] { 5, 11, 3, 50, 60, 90 }, 2);
		maxProfit2(new int[] { 2, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit2(new int[] { 100, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit2(new int[] { 90, 80, 70, 60, 50 }, 2);
		
		System.out.println("==========");
		
		maxProfit3(new int[] { 5, 11, 3, 50, 60, 90 }, 2);
		maxProfit3(new int[] { 2, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit3(new int[] { 100, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit3(new int[] { 90, 80, 70, 60, 50 }, 2);
		
		System.out.println("==========");
		
		maxProfit4(new int[] { 5, 11, 3, 50, 60, 90 }, 2);
		maxProfit4(new int[] { 2, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit4(new int[] { 100, 30, 15, 10, 8, 25, 80 }, 2);
		maxProfit4(new int[] { 90, 80, 70, 60, 50 }, 2);
	}

}
