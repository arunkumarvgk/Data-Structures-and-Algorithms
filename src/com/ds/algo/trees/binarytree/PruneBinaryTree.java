package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class PruneBinaryTree {

	TreeNode pruneTree(TreeNode node) {
		if (node == null) {
			return node;
		}

		node.left = pruneTree(node.left);
		node.right = pruneTree(node.right);

		if (node.val == 0 && node.left == null && node.right == null) {
			return null;
		} else {
			return node;
		}
	}

	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
	}

	public static void main(String[] args) {
		PruneBinaryTree bt = new PruneBinaryTree();
		TreeNode node0 = new TreeNode(1);
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		TreeNode node6 = new TreeNode(1);

		node0.left = node1;
		node0.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		bt.inorder(node0);
		System.out.println();
		bt.pruneTree(node0);
		bt.inorder(node0);
	}

}
