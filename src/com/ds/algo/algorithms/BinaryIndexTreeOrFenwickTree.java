package com.ds.algo.algorithms;

public class BinaryIndexTreeOrFenwickTree {

	static int[] BIT;
	static int n;
	static int arr[];

	private static void build() {
		BIT = new int[arr.length + 1];

		for (int i = 1; i <= arr.length; i++) {
			update(i, arr[i - 1]);
		}
	}

	private static void update(int index, int value) {
		while (index <= n) {
			BIT[index] += value;
			int y = index & -index;
			index = index + y;
		}
	}

	private static int query(int index) {
		int sum = 0;
		while (index > 0) {
			sum = sum + BIT[index];
			index = index - (index & -index);
		}
		return sum;
	}

	private static void print() {
		for (int i = 0; i < BIT.length; i++) {
			System.out.print(BIT[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		arr = new int[] { 4, 6, 2, 1, 7, 12, 5 };
		n = arr.length;
		build();
		print();
		System.out.println(query(5)-query(2));
	}

}
