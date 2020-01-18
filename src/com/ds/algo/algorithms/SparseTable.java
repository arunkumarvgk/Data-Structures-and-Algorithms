package com.ds.algo.algorithms;

public class SparseTable {

	private static int[][] computeSparseTable(int arr[]) {
		int n = arr.length;
		int h = (int) Math.floor((Math.log(n) / Math.log(2)));

		int[][] st = new int[h + 1][n];
		for (int i = 0; i < n; i++) {
			st[0][i] = arr[i];
		}

		for (int i = 1; i <= h; i++) {
			for (int j = 0; (j + (1 << i)) <= n; j++) {
				int a = st[i - 1][j];
				int b = st[i - 1][j + (1 << (i - 1))];

				if (a > b) {
					st[i][j] = b;
				} else {
					st[i][j] = a;
				}

			}
		}

		for (int i = 0; i <= h; i++) {
			for (int j = 0; (j + (1 << i)) <= n; j++) {
				System.out.print(st[i][j] + " ");
			}
			System.out.println(" ");
		}

		return st;
	}

	private static void rmq(int st[][], int s, int e) {
		int l = e - s + 1;// l is no of elements in the given range
		int k = (int) Math.floor(Math.log(l) / Math.log(2));
		int min = st[k][s];

		if (l > Math.pow(2, k)) {
			int temp = st[k][(int) (s + l - Math.pow(2, k))];
			if (temp < min) {
				min = temp;
			}
		}

		System.out.println("Minimum " + min);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 6, 5, 1 };
		int st[][] = computeSparseTable(arr);
		rmq(st, 3, 5);
		rmq(st, 0, 5);
		rmq(st, 0, 3);

		int arr2[] = { 4, 6, 1, 5, 7, 3 };
		int st2[][] = computeSparseTable(arr2);
		rmq(st2, 3, 5);
		rmq(st2, 0, 5);
		rmq(st2, 0, 3);
		rmq(st2, 1, 4);
	}

}
