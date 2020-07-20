package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class SerializeAndDeserialize {

	private static String helper2(Node node) {
		StringBuilder s = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		boolean isLeaf = false;
		while (!queue.isEmpty() && !isLeaf) {
			int length = queue.size();
			isLeaf = true;

			while (length-- != 0) {
				Node temp = queue.poll();
				if (temp != null) {
					if (temp.data == -999) {
						s.append("-1, ");
					} else {
						s.append(temp.data);
						s.append(", ");
					}
				}

				if (temp.leftChild != null) {
					queue.add(temp.leftChild);
					isLeaf = false;
				} else {
					queue.add(new Node(-999));
				}

				if (temp.rightChild != null) {
					isLeaf = false;
					queue.add(temp.rightChild);
				} else {
					queue.add(new Node(-999));
				}
			}
		}
		queue.clear();
		return s.toString();
	}

	private static Node decode(String s) {
		
		int length = s.split(", ").length;
		Node[] list = new Node[length];
		int index[] = {0};
		
		Stream.of(s.split(", ")).forEach(d -> {
			int val = Integer.parseInt(d);
			if (val == -998) {
				list[index[0]] = null;
			} else {
				list[index[0]++] = new Node(val);
			}
		});

		s = null;
		for (int i = 0; i < length; i++) {
			if (list[i] == null) {
				continue;
			}
			Node node = list[i];

			if (length > (2 * i) + 1 && list[(2 * i) + 1] != null) {
				node.leftChild = list[(2 * i) + 1];
			}

			if (length > (2 * i) + 2 && list[(2 * i) + 2] != null) {
				node.rightChild = list[(2 * i) + 2];
			}
		}

		return list[0];
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

		String s = helper2(root);
		System.out.println(s);
		decode(s);
	}
}
