package com.ds.algo.trees.binarytree;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class DiameterBinaryTree {

	private int diameterOfBT2(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		int leftDiameter = diameterOfBT2(node.left);
		int rightDiameter = diameterOfBT2(node.right);

		return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
	}

	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}


	//Store max diameter at any point (left + right) + 1;
	int diameter = 0;
	
	private int diameterOfBT(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		depth(node);
		//diameter count will be no of nodes in longest diameter
		// we should return edges so -1
		return diameter -1;
	}
	
	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int left = depth(node.left);
		int right = depth(node.right);
		
		//if Current diameter is greater than overall then change it
		if (left + right + 1 > diameter) {
			diameter = left + right + 1;
		}
		//return max Height
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		DiameterBinaryTree bt = new DiameterBinaryTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		System.out.println(bt.diameterOfBT(node1));
	}

}
