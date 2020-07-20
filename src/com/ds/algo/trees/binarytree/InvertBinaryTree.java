package com.ds.algo.trees.binarytree;

public class InvertBinaryTree {

	private static Node invert(Node node) {
		if (node == null) {
			return null;
		}

		Node newNode = new Node(node.data);
		newNode.leftChild = invert(node.rightChild);
		newNode.rightChild = invert(node.leftChild);

		return newNode;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		root.leftChild = node2;
		root.rightChild = node3;
		Node root2 = invert(root);

		System.out.println(root2.data);
		System.out.println(root2.leftChild.data);
		System.out.println(root2.rightChild.data);

	}

}
