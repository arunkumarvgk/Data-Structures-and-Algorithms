package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class BinaryTreeTilt {

	public int findTilt(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		tilt(root, list);
		int sum = 0;
		for (int v : list) {
			sum += Math.abs(v);
		}
		return sum;
	}

	private int tilt(TreeNode node, List<Integer> list) {
		if (node == null) {
			return 0;
		}
		list.add(tilt(node.left, list) - tilt(node.right, list));
		return node.val;
	}

	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node6.left = node2;
		node6.right = node8;

		node2.left = node0;
		node2.right = node4;

		node4.left = node3;
		node4.right = node5;

		node8.left = node7;
		node8.right = node9;
		BinaryTreeTilt bt = new BinaryTreeTilt();
		System.out.println(bt.findTilt(node6));
	}

}
