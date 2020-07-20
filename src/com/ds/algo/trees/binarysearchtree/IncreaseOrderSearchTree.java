package com.ds.algo.trees.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Facebook
public class IncreaseOrderSearchTree {

	public TreeNode increasingBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		TreeNode newRoot = new TreeNode(list.get(0));
		TreeNode cur = newRoot;
		for (int i = 1; i < list.size(); i++) {
			cur.right = new TreeNode(list.get(i));
			cur = cur.right;
		}
		return newRoot;
	}

	private void inorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

	public static void main(String[] args) {
		IncreaseOrderSearchTree bst = new IncreaseOrderSearchTree();
		TreeNode head = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node5.left = node3;
		node5.right = node6;

		node3.left = node2;
		node3.right = node4;

		node2.left = head;

		node6.right = node8;

		node8.left = node7;
		node8.right = node9;

		bst.print(node5);
		System.out.println("______________________________________________");
		TreeNode root = bst.increasingBST(node5);
		bst.print(root);
		System.out.println("______________________________________________");
	}

	private void print(TreeNode head) {
		if (head == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(head);

		while (!queue.isEmpty()) {
			int length = queue.size();
			while (length-- != 0) {
				TreeNode temp = queue.poll();
				System.out.print(temp.val + " ");

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println();
		}
	}
}
