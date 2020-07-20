package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperations {

	private static boolean isFullBinaryTree(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		int i = 0;
		while (!queue.isEmpty()) {
			int length = queue.size();
			if (length != Math.pow(2, i++)) {
				return false;
			} else {
				while (length-- != 0) {
					Node temp = queue.poll();
					if (temp.leftChild != null) {
						queue.add(temp.leftChild);
					}

					if (temp.rightChild != null) {
						queue.add(temp.rightChild);
					}
				}
			}
		}
		return true;
	}

	private static boolean isStrictBinaryTree(Node node) {
		if (node == null) {
			return true;
		}

		if (node.leftChild == null && node.rightChild == null) {
			return true;
		}

		if (node.leftChild != null && node.rightChild != null) {
			return isStrictBinaryTree(node.leftChild) && isStrictBinaryTree(node.rightChild);
		}

		return false;
	}

	private static boolean isCompleteBinaryTree(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		boolean endFound = false;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp == null) {
				endFound = true;
			} else {
				if (endFound) {
					// Control comes here when null node is found and still we have node in queue
					return false;
				}

				queue.add(temp.leftChild);
				queue.add(temp.rightChild);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Full BT---------------------------------------");
		System.out.println(isFullBinaryTree(notFullOrCompleteOrStrictBinaryTree()));
		System.out.println(isFullBinaryTree(fullBinaryTree()));
		
		System.out.println("Strict BT---------------------------------------");
		System.out.println(isStrictBinaryTree(notFullOrCompleteOrStrictBinaryTree()));
		System.out.println(isStrictBinaryTree(fullBinaryTree()));
		System.out.println(isStrictBinaryTree(completeBinaryTree()));
		System.out.println(isStrictBinaryTree(strictBinaryTree()));
		System.out.println(isStrictBinaryTree(notCompleteBinaryTree()));

		System.out.println("Complete BT---------------------------------------");
		System.out.println(isCompleteBinaryTree(notCompleteBinaryTree()));
		System.out.println(isCompleteBinaryTree(completeBinaryTree()));
		System.out.println(isCompleteBinaryTree(fullBinaryTree()));
	}

	/**
	 *              1
	 *             / \
	 *            2   3
	 *          / \   / \
	 *         4  5  6   7
	 * 
	 */
	private static Node fullBinaryTree() {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.leftChild = node6;
		node3.rightChild = node7;

		return root;
	}

	/**
	 *               1
	 *             /   \
	 *            2     3
	 *          / \
	 *         4  5
	 * 
	 */
	private static Node strictBinaryTree() {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		return root;
	}
	
	/**
	 *               1
	 *             /   \
	 *            2     3
	 *          / \    /
	 *         4  5   6
	 * 
	 */
	private static Node completeBinaryTree() {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.leftChild = node6;

		return root;
	}
	
	/**
	 *               1
	 *             /   \
	 *            2     3
	 *          / \      \
	 *         4  5       7
	 * 
	 */
	private static Node notCompleteBinaryTree() {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node7 = new Node(7);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.rightChild = node7;
		
		return root;
	}

	/**
	 *              1
	 *             / \
	 *            2   3
	 *           / \   \
	 *          4   5   8
	 *             /\   /
	 *            6  7  9
	 * 
	 */
	private static Node notFullOrCompleteOrStrictBinaryTree() {
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
		return root;
	}

}
