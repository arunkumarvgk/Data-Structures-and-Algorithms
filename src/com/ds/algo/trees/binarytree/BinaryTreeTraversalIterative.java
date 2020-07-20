package com.ds.algo.trees.binarytree;

import java.util.Stack;

public class BinaryTreeTraversalIterative {

	private static void preorder(Node node) {
		Stack<Node> stack = new Stack<>();

		while (node != null || !stack.empty()) {
			if (node != null) {
				System.out.print(node.data + " ");
				stack.push(node);
				node = node.leftChild;
			} else {
				Node temp = stack.pop();
				node = temp.rightChild;
			}
		}
	}

	private static void inorder(Node node) {
		Stack<Node> stack = new Stack<>();

		while (node != null || !stack.empty()) {
			if (node != null) {
				stack.push(node);
				node = node.leftChild;
			} else {
				Node temp = stack.pop();
				node = temp.rightChild;
				System.out.print(temp.data + " ");
			}
		}
	}
	
	private static void postorder(Node node) {
		Stack<Node> stack = new Stack<>();

		while (node != null || !stack.empty()) {
			if (node != null) {
				stack.push(node);
				node = node.leftChild;
			} else {
				Node temp = stack.peek();
				if (temp.rightChild == null) {
					stack.pop();
					System.out.print(temp.data + " ");
					
					while (! stack.empty() && stack.peek().rightChild == temp) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				} else {
					node = temp.rightChild;
				}
			}
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
		//preorder(root);
		System.out.println();
		//inorder(root);
		System.out.println();
		postorder(root);
	}
}
