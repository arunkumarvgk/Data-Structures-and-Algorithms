package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class PrintPositions {

	private void printPositions(TreeNode node, int depth, int position) {
		if (node == null) {
			return;
		}
		
		System.out.println(node.val+" "+depth+" "+position);
		printPositions(node.left, depth + 1, 2 * position);
		printPositions(node.right, depth + 1, 2 * position + 1);
	}

	public static void main(String[] args) {
		
		PrintPositions bt = new PrintPositions();
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node6;
		node5.right = node7;

		node3.right = node8;
		node8.left = node9;
		node8.right = node10;
		
		bt.printPositions(root, 0, 0);
	}

}
