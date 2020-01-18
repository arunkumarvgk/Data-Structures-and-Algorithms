package com.ds.algo.array.range;

public class QueriesForDecNumOfSubArrOfABinaryArray {

	private static void precompute(int arr[], int pre[]) {
		int n = arr.length;

		pre[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			pre[i] = pre[i + 1] + arr[i] * (1 << n - 1 - i);
		}

		for (int i = 0; i < pre.length; i++) {
			System.out.print(pre[i] + " ");
		}
		System.out.println();
	}

	private static void query(int pre[], int l, int r) {
		int n = pre.length;

		if (r == n - 1 || (l==0 && r == n - 1)) {
			System.out.println("S1 :: "+pre[l]);
		} else {
			System.out.println("S2 :: "+(pre[l] - pre[r + 1]) / (1 << (n - 1 - r))); 
		}
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1 };
		int pre[] = new int[arr.length];
		precompute(arr, pre);
		query(pre, 0, 4);
		query(pre, 1, 4);
		query(pre, 2, 4);
		query(pre, 3, 4);
		
		query(pre, 0, 3);
		query(pre, 1, 3);
		query(pre, 2, 3);
		
		query(pre, 0, 2);
		query(pre, 1, 2);
		
		query(pre, 0, 1);
	}

}
