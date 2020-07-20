package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class BoundaryBT {
	
	List<Integer> list = new ArrayList<>();
	
	private List<Integer> boundary(TreeNode root) {
		if (root == null) return list;
		
		list.add(root.val);
		leftView(root.left);
		bottomView(root);
		rightview(root.right);
		return list;
	}

	private void rightview(TreeNode node) {
		if (node == null) return;
		if (node.left == null && node.right == null) return;
		
		if (node.right != null) {
			rightview(node.right);
		} else {
			rightview(node.left);
		}
		list.add(node.val);
	}

	private void bottomView(TreeNode node) {
		if (node == null) return;
		if (node.left == null && node.right == null) {
			list.add(node.val);
		}
		bottomView(node.left);
		bottomView(node.right);
	}

	private void leftView(TreeNode node) {
		if (node == null) return;
		if (node.left == null && node.right == null) return;
		
		list.add(node.val);
		if (node.left != null) {
			leftView(node.left);
		} else {
			leftView(node.right);
		}
	}

	public static void main(String[] args) {

		BoundaryBT bt = new BoundaryBT();

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node6;
		node5.right = node7;

		node3.right = node8;
		node8.left = node9;

		List<Integer> result = bt.boundary(root);

		result.stream().forEach(v -> System.out.print(v + " "));
	}

}
