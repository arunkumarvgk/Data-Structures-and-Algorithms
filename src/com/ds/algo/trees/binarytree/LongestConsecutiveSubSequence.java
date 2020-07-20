package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class LongestConsecutiveSubSequence {

	static int max = 0;
	int cur = 1;

	private void find(TreeNode node, TreeNode parent, int cur) {
		max = Math.max(max, cur);
		if (node == null)
			return;

		if (parent != null) {
			if (parent.val == node.val - 1) {
				cur += 1;
			} else {
				cur = 1;
			}
		}

		find(node.left, node, cur);
		find(node.right, node, cur);
	}

	public static void main(String[] args) {
		LongestConsecutiveSubSequence bt = new LongestConsecutiveSubSequence();

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);

		node8.left = node10;
		node8.right = node5;

		node10.left = node3;
		node10.right = node2;

		node3.left = node1;
		node3.right = node9;

		node2.left = node4;

		node5.left = node7;
		node5.right = node6;
		max = 0;
		bt.find(node8, null, 1);
		System.out.println(max);
	}
}
