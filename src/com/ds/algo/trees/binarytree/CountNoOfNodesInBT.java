package com.ds.algo.trees.binarytree;

public class CountNoOfNodesInBT {

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

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node3.rightChild = node8;
		node8.leftChild = node9;
		System.out.println(count(root));
		System.out.println(getLeafCount(root));
		System.out.println(getNonLeafCount(root));
	}

	private static int count(Node node) {
		int x = 0;
		int y = 0;
		if (node != null) {
			x = count(node.leftChild);
			y = count(node.rightChild);
			return x + y + 1;
		}
		return 0;
	}

	private static int getLeafCount(Node node) {
		int x = 0;
		int y = 0;
		if (node != null) {
			x = count(node.leftChild);
			y = count(node.rightChild);
			if (node.leftChild == null && node.rightChild == null) {
				return x + y + 1;
			} else {
				return x + y;
			}
			
		}
		return 0;
	}

	private static int getNonLeafCount(Node node) {
		int x = 0;
		int y = 0;
		if (node != null) {
			x = count(node.leftChild);
			y = count(node.rightChild);
			if (node.leftChild != null || node.rightChild != null) {
				return x + y + 1;
			} else {
				return x + y;
			}
			
		}
		return 0;
	}
}
