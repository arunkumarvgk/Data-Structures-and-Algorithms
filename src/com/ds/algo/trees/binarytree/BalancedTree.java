package com.ds.algo.trees.binarytree;

public class BalancedTree {

	private int bt(Node node) {
		if (node == null) {
			return 0;
		}

		int left = bt(node.leftChild);
		if (left == -1) {
			return -1;
		}
		int right = bt(node.rightChild);
		if (right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;

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
		Node node11 = new Node(11);
		Node node12 = new Node(12);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node7.rightChild = node9;
		
		node9.rightChild = node10;
		System.out.println(new BalancedTree().bt(root) != -1);
	}

}
