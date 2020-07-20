package com.ds.algo.trees.binarysearchtree;

public class GreaterTree {

	int sum = 0;
	
	private TreeNode convertToGreaterTree(TreeNode node) {
		if (node != null) {
			convertToGreaterTree(node.right);
			sum = sum + node.val;
			node.val = sum;
			convertToGreaterTree(node.left);
		}
		return node;
	}
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.val+" ");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		
		GreaterTree bst = new GreaterTree();
		TreeNode node0 = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		
		node0.left = node1;
		node0.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		
		bst.inorder(node0);
		bst.convertToGreaterTree(node0);
		System.out.println();
		bst.inorder(node0);
		
	}

}
