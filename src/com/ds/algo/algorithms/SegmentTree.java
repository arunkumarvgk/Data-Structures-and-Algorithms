package com.ds.algo.algorithms;

public class SegmentTree {

	static int[] tree;
	static int[] minTree;
	static int[] maxTree;
	static int[] arr;

	private static void update(int node, int start, int end, int index, int val) {
		if (start == end) {
			arr[index] =  val;
			tree[node] =  val;
		} else {
			int mid = (start + end) / 2;

			if (start <= index && mid >= index) {
				update(2 * node + 1, start, mid, index, val);
			} else {
				update(2 * node + 2, mid + 1, end, index, val);
			}
			
			tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
		}
	}

	private static void buildSum(int node, int start, int end) {
		if (start == end) {
			// Leaf node will have a single element
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			// Recurse on the left child
			buildSum(2 * node + 1, start, mid);
			// Recurse on the right child
			buildSum(2 * node + 2, mid + 1, end);
			// Internal node will have the sum of both of its children
			tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
		}
	}

	private static void buildMin(int node, int start, int end) {
		if (start == end) {
			// Leaf node will have a single element
			minTree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			// Recurse on the left child
			buildMin(2 * node + 1, start, mid);
			// Recurse on the right child
			buildMin(2 * node + 2, mid + 1, end);
			// Internal node will have the sum of both of its children
			minTree[node] = minTree[2 * node + 1] < minTree[2 * node + 2] ? minTree[2 * node + 1]
					: minTree[2 * node + 2];
		}
	}

	private static void buildMax(int node, int start, int end) {
		if (start == end) {
			maxTree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			buildMax(node * 2 + 1, start, mid);
			buildMax(node * 2 + 2, mid + 1, end);
			maxTree[node] = maxTree[2 * node + 1] > maxTree[2 * node + 2] ? maxTree[2 * node + 1]
					: maxTree[2 * node + 2];
		}
	}

	private static void printTree() {
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < minTree.length; i++) {
			System.out.print(minTree[i] + " ");
		}
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < maxTree.length; i++) {
			System.out.print(maxTree[i] + " ");
		}
	}

	public static void main(String[] args) {
		arr = new int[] { 1, 3, 5, 7, 9, 11 };

		int n = arr.length;
		int treeSize = (int) Math.ceil(Math.log(n) / Math.log(2));
		treeSize = (int) Math.pow(2, treeSize) * 2 - 1;
		tree = new int[treeSize];
		minTree = new int[treeSize];
		maxTree = new int[treeSize];

		buildSum(0, 0, n - 1);
		buildMin(0, 0, n - 1);
		buildMax(0, 0, n - 1);

		printTree();

		System.out.println();
		System.out.println(querySum(0, 0, n - 1, 2, 4));
		System.out.println(querySum(0, 0, n - 1, 1, 4));
		System.out.println(querySum(0, 0, n - 1, 0, 4));
		System.out.println(querySum(0, 0, n - 1, 3, 5));
		System.out.println("-----------------------------------------------------------");
		System.out.println(queryMin(0, 0, n - 1, 2, 4));
		System.out.println(queryMin(0, 0, n - 1, 1, 4));
		System.out.println(queryMin(0, 0, n - 1, 0, 4));
		System.out.println(queryMin(0, 0, n - 1, 3, 5));
		System.out.println("-----------------------------------------------------------");
		System.out.println(queryMax(0, 0, n - 1, 2, 4));
		System.out.println(queryMax(0, 0, n - 1, 1, 4));
		System.out.println(queryMax(0, 0, n - 1, 0, 4));
		System.out.println(queryMax(0, 0, n - 1, 3, 5));
		System.out.println("-----------------------------------------------------------");
		
		update(0, 0, n-1, 3, 8);
		
		printTree();

		System.out.println();
		System.out.println("After Update");
		System.out.println(querySum(0, 0, n - 1, 2, 4));
		System.out.println(querySum(0, 0, n - 1, 1, 4));
		System.out.println(querySum(0, 0, n - 1, 0, 4));
		System.out.println(querySum(0, 0, n - 1, 3, 5));
	}

	private static int querySum(int pos, int s, int e, int l, int r) {
		//No overlap
		if (r < s || l > e) {
			return 0;
		}

		//total overlap: = given range completly overlaps s-e eg: = l-r = 0,3 s-e = 0-0, 1-1, 2-2, 3-3, 0-1,0-2
		if (l <= s && r >= e) {
			return tree[pos];
		}

		//partial overlap
		int mid = (s + e) / 2;
		int p1 = querySum(2 * pos + 1, s, mid, l, r);
		int p2 = querySum(2 * pos + 2, mid + 1, e, l, r);
		return p1 + p2;
	}

	private static int queryMin(int pos, int s, int e, int l, int r) {
		if (r < s || l > e) {
			return Integer.MAX_VALUE;
		}

		if (l <= s && r >= e) {
			return minTree[pos];
		}
		int mid = (s + e) / 2;
		int p1 = queryMin(2 * pos + 1, s, mid, l, r);
		int p2 = queryMin(2 * pos + 2, mid + 1, e, l, r);
		if (p1 > p2) {
			return p2;
		} else {
			return p1;
		}
	}

	private static int queryMax(int pos, int s, int e, int l, int r) {
		if (r < s || l > e) {
			return Integer.MIN_VALUE;
		}

		if (l <= s && r >= e) {
			return maxTree[pos];
		}
		int mid = (s + e) / 2;
		int p1 = queryMax(2 * pos + 1, s, mid, l, r);
		int p2 = queryMax(2 * pos + 2, mid + 1, e, l, r);
		if (p1 < p2) {
			return p2;
		} else {
			return p1;
		}
	}

}
