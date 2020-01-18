package com.ds.algo.array.range;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfDistinctElementsInGivenSubarray {

	static Set<Integer> segment[];
	static int[] arr;

	private static void addToSet(int index, int value) {
		if (segment[index] == null) {
			segment[index] = new HashSet<Integer>();
		}
		segment[index].add(value);
	}

	private static void build(int node, int start, int end) {
		if (start == end) {
			addToSet(node, arr[start]);
		} else {
			int mid = (start + end) / 2;
			build(2 * node + 1, start, mid);
			build(2 * node + 2, mid + 1, end);

			Set<Integer> rightSet = segment[2 * node + 1];
			Set<Integer> leftSet = segment[2 * node + 2];

			rightSet.forEach(val -> addToSet(node, val));
			leftSet.forEach(val -> addToSet(node, val));
		}
	}

	public static void main(String[] args) {
		arr = new int[] { 1, 1, 2, 1, 3 };
		int n = arr.length;
		int treeSize = (int) Math.ceil(Math.log(n) / Math.log(2));
		treeSize = (int) (Math.pow(2, treeSize) * 2) - 1;

		segment = new HashSet[treeSize];

		build(0, 0, n - 1);
		print();

		System.out.println("Query 0-4 -> " + query(0, 0, n - 1, 0, 4).size());
		System.out.println("Query 1-4 -> " + query(0, 0, n - 1, 1, 4).size());
		System.out.println("Query 2-4 -> " + query(0, 0, n - 1, 2, 4).size());
		System.out.println("Query 3-4 -> " + query(0, 0, n - 1, 3, 4).size());
		System.out.println("Query 4-4 -> " + query(0, 0, n - 1, 4, 4).size());
		
		System.out.println("Query 0-3 -> " + query(0, 0, n - 1, 0, 3).size());
		System.out.println("Query 1-3 -> " + query(0, 0, n - 1, 1, 3).size());
		System.out.println("Query 2-3 -> " + query(0, 0, n - 1, 2, 3).size());
		System.out.println("Query 3-3 -> " + query(0, 0, n - 1, 3, 3).size());
		
		System.out.println("Query 0-2 -> " + query(0, 0, n - 1, 0, 2).size());
		System.out.println("Query 1-2 -> " + query(0, 0, n - 1, 1, 2).size());
		System.out.println("Query 2-2 -> " + query(0, 0, n - 1, 2, 2).size());
		
		System.out.println("Query 0-1 -> " + query(0, 0, n - 1, 0, 1).size());
		System.out.println("Query 1-1 -> " + query(0, 0, n - 1, 1, 1).size());
		
		System.out.println("Query 0-0 -> " + query(0, 0, n - 1, 0, 0).size());
	}

	private static void print() {
		int i = 0;
		for (Set<Integer> set : segment) {
			System.out.print(i++ + " -> ");
			if (set != null) {
				set.forEach(val -> System.out.print(val + " "));
			}
			System.out.println();
		}

	}

	private static Set<Integer> query(int node, int start, int end, int l, int r) {
		Set<Integer> result = new HashSet<>();
		if (r < start || l > end) {
			return result;
		}

		if (l <= start && r >= end) {
			return segment[node];
		}

		int mid = (start + end) / 2;
		Set<Integer> rightSet = query(2 * node + 1, start, mid, l, r);
		Set<Integer> leftSet = query(2 * node + 2, mid + 1, end, l, r);
		rightSet.forEach(val -> result.add(val));
		leftSet.forEach(val -> result.add(val));
		return result;
	}
}
