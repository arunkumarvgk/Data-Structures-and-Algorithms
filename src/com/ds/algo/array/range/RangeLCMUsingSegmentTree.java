package com.ds.algo.array.range;

public class RangeLCMUsingSegmentTree {

	static int[] arr;
	static int[] tree;

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private static void buildSegmentTree(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			buildSegmentTree(2 * node + 1, start, mid);
			buildSegmentTree(2 * node + 2, mid + 1, end);
			tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
		}
	}

	private static int query(int node, int start, int end, int l, int r) {
		if (r < start || l > end) {
			return 1;
		}

		if (l <= start && r >= end) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		int p1 = query(2 * node + 1, start, mid, l, r);
		int p2 = query(2 * node + 2, mid + 1, end, l, r);
		return lcm(p1, p2);
	}

	public static void main(String[] args) {
		arr = new int[] { 5, 7, 5, 2, 10, 12, 11, 17, 14, 1, 44 };
		int n = arr.length;
		int treeSize = (int) Math.ceil(Math.log(n) / Math.log(2));
		treeSize = (int)( Math.pow(2, treeSize) *2 ) -1;
		tree = new int[treeSize];

		buildSegmentTree(0, 0, n - 1);
		System.out.println(query(0, 0, n - 1, 2, 5));
		System.out.println(query(0, 0, n - 1, 5, 10));
		System.out.println(query(0, 0, n - 1, 0, 10));
	}

}
