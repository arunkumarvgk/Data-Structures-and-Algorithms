package com.ds.algo.trees.binarysearchtree;
/**
 * 1373. Maximum Sum BST in Binary Tree
 * 
 * Given a binary tree root, the task is to return the maximum sum of 
 * all keys of any sub-tree which is also a Binary Search Tree (BST).
 *
 * Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * Output: 20
 * Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
 */
public class MaximumBST {

	class MaxBST {
		int min;
		int max;
		int size;
		boolean isBST;
		
		MaxBST() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			isBST = true;
			size = 0;
		}
	}
	
	int maxSum = 0;
	private int maxSumBST(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int size = findSum(root).size;
		return maxSum > 0 ? maxSum : 0;
	}
	
	private MaxBST findSum(TreeNode node) {
		if (node == null) {
			return new MaxBST();
		}
		
		MaxBST left = findSum(node.left);
		MaxBST right = findSum(node.right);
		
		MaxBST m = new MaxBST();
		if (left.isBST && right.isBST && node.val > left.max && node.val < right.min ) {
			m.isBST = true;
			m.size = left.size + right.size + node.val;
			maxSum = Math.max(maxSum, m.size);
			m.min = Math.min(node.val, left.min);
			m.max = Math.max(node.val, right.max);
		} else {
			m.isBST = false;
			m.size = Math.max(left.size, right.size);
		}
		return m;
	}

	private int maxSizeBST(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int size = findSize(root).size;
		return size > 0 ? size : 0;
	}
	
	private MaxBST findSize(TreeNode node) {
		if (node == null) {
			return new MaxBST();
		}
		
		MaxBST left = findSize(node.left);
		MaxBST right = findSize(node.right);
		
		MaxBST m = new MaxBST();
		if (left.isBST && right.isBST && node.val > left.max && node.val < right.min ) {
			m.isBST = true;
			m.size = left.size + right.size + 1;
			m.min = Math.min(node.val, left.min);
			m.max = Math.max(node.val, right.max);
		} else {
			m.isBST = false;
			m.size = Math.max(left.size, right.size);
		}
		return m;
	}
	
	public static void main(String[] args) {
		MaximumBST bst = new MaximumBST();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node44 = new TreeNode(4);
		TreeNode node444 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node4;
		node1.right = node3;
		
		node4.left = node2;
		node4.right = node44;
		
		node3.left = node22;
		node3.right = node5;
		
		node5.left = node444;
		node5.right = node6;
		
		//System.out.println(bst.maxSumBST(node1));
		
		System.out.println(bst.maxSumBST(createInput()));
	}

	private static TreeNode createInput() {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(-5);
		TreeNode node7 = new TreeNode(4);
		TreeNode node8 = new TreeNode(-3);
		TreeNode node9 = new TreeNode(10);
	
		node1.left = node2;
		
		node2.left = node3;
		node2.right = node4;
		
		node3.left = node5;
		
		node4.left = node6;
		node4.right = node7;
		
		node6.right = node8;
		node7.right = node9;
		
		return node1;
	}

}
