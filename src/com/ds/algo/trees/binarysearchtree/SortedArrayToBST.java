package com.ds.algo.trees.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		return create(0, nums.length - 1, nums);
	}

	private TreeNode create(int l, int r, int nums[]) {
		if (l > r) {
			return null;
		}
		int m = (l + r) / 2;
		TreeNode cur = new TreeNode(nums[m]);
		cur.left = create(l, m - 1, nums);
		cur.right = create(m + 1, r, nums);
		return cur;
	}

	public static void main(String[] args) {
		SortedArrayToBST bst = new SortedArrayToBST();
		TreeNode node = bst.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		bst.print(node);
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
