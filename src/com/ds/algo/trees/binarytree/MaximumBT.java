package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class MaximumBT {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}

	private TreeNode construct(int nums[], int l, int r) {
		int index = findMaxIndex(nums, l, r);
		if (index < 0) {
			return null;
		}

		TreeNode node = new TreeNode(nums[index]);
		node.left = construct(nums, l, index - 1);
		node.right = construct(nums, index + 1, r);
		return node;
	}

	private int findMaxIndex(int arr[], int left, int right) {
		if (left > right) {
			return -1;
		}

		int max = arr[left];
		int index = left;
		for (int i = left + 1; i < right; i++) {
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
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
		MaximumBT bt = new MaximumBT();

		TreeNode node = bt.constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
		bt.inorder(node);
	}

}
