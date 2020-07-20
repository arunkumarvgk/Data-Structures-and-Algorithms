package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

/**
 * 
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * Input: [-10,9,20,null,null,15,7] result : 42 path {15, 20, 7}
 */
public class MaximumPathSumBT {
	int max = 0;

	private int maxPath(TreeNode root) {
		postorder(root);
		return max;
	}

	private int postorder(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int left = postorder(node.left);
		int right = postorder(node.right);
		
		max = Math.max(max, left + right + node.val);
		return Math.max(left, right) + node.val; // Path cannot both left and right child when its parents path is calculated
	}
	

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(-10);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		MaximumPathSumBT bt = new MaximumPathSumBT();
		System.out.println(bt.maxPath(node1));
	}

}
