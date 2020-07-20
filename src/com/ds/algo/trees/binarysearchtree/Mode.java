package com.ds.algo.trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class Mode {

	int i = -1;
	boolean added = false;
	boolean duplicates = false;

	public int[] findMode(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		int arr[];
		if (root == null) {
			return new int[] {};
		}
		traverse(root, list);
		arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	private void traverse(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		boolean left = search(node.left, node.val);
		boolean right = search(node.right, node.val);
		if (left || right) {
			if (!duplicates) {
				duplicates = true;
				list.clear();
			}
			list.add(node.val);
		}

		if (!duplicates) {
			list.add(node.val);
		}

		traverse(node.left, list);
		traverse(node.right, list);
	}

	private boolean search(TreeNode node, int val) {
		if (node == null) {
			return false;
		}

		while (node != null && node.val != val) {
			node = node.val > val ? node.left : node.right;
		}

		return node != null;
	}

	public static void main(String[] args) {
		Mode bst = new Mode();

		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node66 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node6.left = node2;
		node6.right = node8;

		node2.left = node0;
		node2.right = node4;

		node4.left = node22;
		node4.right = node66;

		node8.left = node7;
		node8.right = node9;
		int arr[] = bst.findMode(node6);
		for (int i : arr) {
			System.out.print(i + " - ");
		}
	}

}
