package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MirrorOrSymetricTree {

	private static boolean isSymmetricTree(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		// If any one of them is null. if both are null control doesn't come here
		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.data == node2.data) {
			return isSymmetricTree(node1.leftChild, node2.rightChild)
					&& isSymmetricTree(node1.rightChild, node2.leftChild);
		}

		return false;
	}

	private static boolean check(Node node) {
		return isSymmetricTree(node, node);
	}

	private static boolean check2(Node n) {
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(n);
		boolean root = true;
		while (!queue.isEmpty()) {
			int length = queue.size();

			if (!root) {
				if (queue.size() % 2 != 0) {
					return false;
				}
			}
			int half = length / 2;
			while (length != 0) {
				Node temp = queue.poll();

				if (!root) {
					if (half < length) {
						stack.push(temp);
					} else {
						Node stackTemp = stack.pop();
						if (temp == null && stackTemp != null || temp != null && stackTemp == null) {
							return false;
						}
						if (stackTemp == null && temp == null) {
							length--;
							continue;
						}
						if (stackTemp.data != temp.data) {
							return false;
						}
					}
				}
				if (temp != null) {
					queue.add(temp.leftChild);
					queue.add(temp.rightChild);
				}

				root = false;
				length--;
			}
		}

		return true;
	}

	private static boolean checkMirror(Queue<Node> queue) {
		Queue<Node> temp = new LinkedList<>();

		if (queue.size() % 2 == 0) {

			for (int i = 0; i < queue.size(); i++) {
				temp.add(queue.peek());
			}

			Stack<Node> stack = new Stack<>();
			for (int i = 0; i < temp.size() / 2; i++) {
				stack.push(temp.poll());
			}

			while (!stack.empty()) {
				if (temp.poll() != stack.pop()) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(4);
		Node node6 = new Node(3);
		Node node7 = new Node(3);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.leftChild = node6;
		node3.rightChild = node7;

		System.out.println(check(root));
	}

}
