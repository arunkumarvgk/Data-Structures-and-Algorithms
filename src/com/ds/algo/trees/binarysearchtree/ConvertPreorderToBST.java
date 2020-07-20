package com.ds.algo.trees.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertPreorderToBST {

	private TreeNode convert(int preorder[]) {
		if (preorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);

		for (int i = 1; i < preorder.length; i++) {
			insert(root, new TreeNode(preorder[i]));
		}

		return root;
	}

	private void insert(TreeNode root, TreeNode node) {
		TreeNode prev = null;
		while (root != null) {
			prev = root;

			root = (node.val < root.val) ? root.left : root.right;
		}

		if (node.val < prev.val) {
			prev.left = node;
		} else {
			prev.right = node;
		}
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

	public static void main(String[] args) {
		ConvertPreorderToBST bst = new ConvertPreorderToBST();
		bst.print(bst.convert(new int[] { 8, 5, 1, 7, 10, 12 }));
	}

}
