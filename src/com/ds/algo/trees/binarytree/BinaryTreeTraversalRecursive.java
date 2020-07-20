package com.ds.algo.trees.binarytree;

public class BinaryTreeTraversalRecursive {

	private static void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.leftChild);
			preorder(node.rightChild);
		}
	}

	private static void inorder(Node node) {
		if (node != null) {
			inorder(node.leftChild);
			System.out.print(node.data + " ");
			inorder(node.rightChild);
		}
	}

	private static void postorder(Node node) {
		if (node != null) {
			postorder(node.leftChild);
			postorder(node.rightChild);
			System.out.print(node.data + " ");
		}
	}

	private static void preorder(int arr[], int i) {
		if (i < arr.length && arr[i] != 0) {
			System.out.print(arr[i] + " ");
			preorder(arr, (2 * i) + 1);
			preorder(arr, (2 * i) + 2);
		}
	}

	private static void inorder(int arr[], int i) {
		if (i < arr.length && arr[i] != 0) {
			inorder(arr, (2 * i) + 1);
			System.out.print(arr[i] + " ");
			inorder(arr, (2 * i) + 2);
		}
	}

	private static void postorder(int arr[], int i) {
		if (i < arr.length && arr[i] != 0) {
			postorder(arr, (2 * i) + 1);
			postorder(arr, (2 * i) + 2);
			System.out.print(arr[i] + " ");
		}
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

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node3.rightChild = node8;
		node8.leftChild = node9;

		System.out.println("Linked Representation");
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);

		System.out.println();
		System.out.println("Arrays Representation");
		int arr[] = new int[] { 1, 2, 3, 4, 5, 0, 8, 0, 0, 6, 7, 0, 0, 9 };
		preorder(arr, 0);
		System.out.println();
		inorder(arr, 0);
		System.out.println();
		postorder(arr, 0);
	}
}
