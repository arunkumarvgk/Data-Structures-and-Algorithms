package com.ds.algo.trees.binarytree;

public class BinaryTreeOperations2 {

	/**
	 *              1
	 *             / \
	 *            2   3
	 *           / \   \
	 *          4   5   8
	 *             /\   / \
	 *            6  7  9  10
	 * 
	 */
	private static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = maxDepth(node.leftChild);
		int rightDepth = maxDepth(node.rightChild);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	private static int minDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = minDepth(node.leftChild);
		int rightDepth = minDepth(node.rightChild);
		return leftDepth == 0 || rightDepth == 0 ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
	}
	
	private static int getLeafNodesCount(Node node) {
		if (node == null) {
			return 0;
		}
		
		if (node.leftChild == null && node.rightChild == null) {
			System.out.print(node.data+" ");
			return 1;
		} else {
			return getLeafNodesCount(node.leftChild) + getLeafNodesCount(node.rightChild);
		}
	}

	private static int getLeafNonNodesCount(Node node) {
		if (node == null) {
			return 0;
		}
		
		if (node.leftChild != null || node.rightChild != null) {
			return getLeafNonNodesCount(node.leftChild) + getLeafNonNodesCount(node.rightChild) + 1;
		} else {
			return 0;
		}
	}

	private static int getNodeWithDegree2(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.leftChild != null && node.rightChild != null) {
			return getNodeWithDegree2(node.leftChild) + getNodeWithDegree2(node.rightChild) + 1;
		}
		return getNodeWithDegree2(node.leftChild) + getNodeWithDegree2(node.rightChild);
	}

	private static int getNodeWithDegree1(Node node) {
		if (node == null) {
			return 0;
		}
		
		if (node.leftChild != null && node.rightChild == null) {
			return getNodeWithDegree2(node.leftChild) + 1;
		}
		
		if (node.leftChild == null && node.rightChild != null) {
			return getNodeWithDegree2(node.rightChild) + 1;
		}
		
		return getNodeWithDegree2(node.leftChild) + getNodeWithDegree2(node.rightChild);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node3.rightChild = node8;
		node8.leftChild = node9;
		//node8.rightChild = node10;
		
		System.out.println("Max "+maxDepth(root));
		System.out.println("Min "+minDepth(root));
		System.out.println("Leaf nodes "+getLeafNodesCount(root));
		System.out.println("Non leaf nodes "+getLeafNonNodesCount(root));
		System.out.println("Nodes with degree two "+getNodeWithDegree2(root));
		System.out.println("Nodes with degree one "+getNodeWithDegree1(root));
	}

}
