package com.ds.algo.trees.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		if (root.val >= L && root.val <= R) {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		} else if (root.val < L) {
			root = trimBST(root.right, L, R);
		} else if (root.val > R) {
			root = trimBST(root.left, L, R);
		}
		return root;
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
		TrimBST bst = new TrimBST();
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node3.left = node0;
		node3.right = node4;

		node0.right = node2;
		node2.left = node1;

		bst.print(node3);

		TreeNode newHead = bst.trimBST(node3, 1, 3);
		System.out.println();
		bst.print(newHead);
	}

}
