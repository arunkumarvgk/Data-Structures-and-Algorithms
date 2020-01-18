package com.ds.algo.array.range;

public class RangeGCDUsingSegmentTree2 {

	static int[] arr;
	static int[] tree;

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	private static void buildSegmentTree(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			buildSegmentTree(2 * node + 1, start, mid);
			buildSegmentTree(2 * node + 2, mid + 1, end);
			tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
		}
	}

	private static int query(int node, int start, int end, int l, int r) {
		if (r < start || l > end) {
			return 0;
		}

		if (l <= start && r >= end) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		int p1 = query(2 * node + 1, start, mid, l, r);
		int p2 = query(2 * node + 2, mid + 1, end, l, r);
		return gcd(p1, p2);
	}

	public static void main(String[] args) {
		arr = new int[] { 3, 4, 2, 2, 4, 6 };
		int n = arr.length;
		int treeSize = (int) Math.ceil(Math.log(n) / Math.log(2));
		treeSize = (int) (Math.pow(2, treeSize) * 2) - 1;
		tree = new int[treeSize];

		buildSegmentTree(0, 0, n - 1);
		System.out.println(query(0, 0, n - 1, 1, 5));
		System.out.println(query(0, 0, n - 1, 0, 3));
		//System.out.println(query(0, 0, n - 1, 0, 2));
	}

}
