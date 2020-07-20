package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class NodeE {
	int data;
	NodeE left;
	NodeE right;
	NodeE next;

	public NodeE(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
	}
}

public class PopulateNextRightPointer {

	private static void nextPointer(NodeE node) {
		if (node != null && node.left != null) {
			node.left.next = node.right;
			if (node.next != null) {
				node.right.next = node.next.left;
			}
			nextPointer(node.left);
			nextPointer(node.right);
		}
	}

	private static void nextPtr(NodeE node) {

		if (node == null) {
			return;
		}

		NodeE cur = node;
		NodeE prev = null;

		while (cur != null) {
			if (prev == null) {
				prev = cur.left;
			} else if (prev != null && cur.left != null) {
				prev.next = cur.left;
				prev = prev.next;
			}

			if (prev == null) {
				prev = cur.right;
			} else if (prev != null && cur.right != null) {
				prev.next = cur.right;
				prev = prev.next;
			}

			cur = cur.next;
		}
		nextPtr(node.left);
		nextPtr(node.right);

	}

	public static void main(String[] args) {
		NodeE root = new NodeE(1);
		NodeE node2 = new NodeE(2);
		NodeE node3 = new NodeE(3);
		NodeE node4 = new NodeE(4);
		NodeE node5 = new NodeE(5);
		NodeE node6 = new NodeE(6);
		NodeE node7 = new NodeE(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		// nextPointer(root);
		// levelOrder(root);
		// System.out.println(root.data);
		test();
	}

	private static void test() {
		NodeE root = new NodeE(1);
		NodeE node2 = new NodeE(2);
		NodeE node3 = new NodeE(3);
		NodeE node4 = new NodeE(4);
		NodeE node5 = new NodeE(5);
		NodeE node6 = new NodeE(6);
		NodeE node7 = new NodeE(7);
		NodeE node8 = new NodeE(8);
		NodeE node9 = new NodeE(9);
		NodeE node10 = new NodeE(10);
		NodeE node11 = new NodeE(11);
		NodeE node12 = new NodeE(12);
		NodeE node13 = new NodeE(13);
		NodeE node14 = new NodeE(14);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		node4.left = node8;
		node4.right = node9;

		node5.right = node10;
		node6.left = node11;

		node7.right = node12;

		node8.right = node13;
		node12.right = node14;

		nextPtr(root);
		print(root);
	}

	private static void levelOrder(NodeE node) {
		Queue<NodeE> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			NodeE temp = queue.poll();
			System.out.println(temp.data + " [ " + (temp.next != null ? temp.next.data : "#") + " ]");
			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static void print(NodeE node) {
		Queue<NodeE> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int length = queue.size();

			while (length-- != 0) {
				NodeE temp = queue.poll();

				if (temp != null) {
					System.out.print(temp.data + " -> " + " [ " + (temp.next != null ? temp.next.data : "#") + " ], ");
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println();
		}
	}
	
	private static void nextprtUsingQueue(NodeE node) {
		Queue<NodeE> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int length = queue.size();

			while (length-- != 0) {
				NodeE temp = queue.poll();

				if (length != 0) {
					temp.next = queue.peek();
				}

				if (temp != null) {
					System.out.print(temp.data + " -> " + " [ " + (temp.next != null ? temp.next.data : "#") + " ], ");
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println();
		}
	}

}
