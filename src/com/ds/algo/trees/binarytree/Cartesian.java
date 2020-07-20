package com.ds.algo.trees.binarytree;

import java.util.ArrayList;

public class Cartesian {

	private static Node construct(int s, int e, int arr[]) {
		if (s > e) {
			return null;
		}

		if (s == e) {
			return new Node(arr[s]);
		}

		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = s; i <= e; i++) {
			if (min > arr[i]) {
				min = arr[i];
				index = i;
			}
		}

		Node node = new Node(min);
		node.leftChild = construct(s, index - 1 , arr);
		node.rightChild = construct(index + 1, e, arr);
		return node;
	}

	private static Node cartesianTree(int start, int end, ArrayList<Integer> list) {
		if (start > end || start == end) {
			return null;
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;

		for (int i = start; i < end; i++) {
			if (max < list.get(i)) {
				max = list.get(i);
				maxIndex = i;
			}
		}

		Node node = new Node(max);
		node.leftChild = cartesianTree(start, maxIndex, list);
		node.rightChild = cartesianTree(maxIndex + 1, end, list);
		return node;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 6, 4, 1, 2, 7 };
		Node head = construct(0, arr.length, arr);

		ArrayList<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(2);
		al.add(1);
		
		//Node head2 = cartesianTree(0, al.size(), al);
	}

}
