package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SumRootRoLeafNodes {

	static List<Integer> list = new ArrayList<>();

	private static void find(Node node, int unit, int value) {
		value = unit * value;
		value = value + node.data;

		if (node.leftChild == null && node.rightChild == null) {
			list.add(value);
		}

		if (node.leftChild != null) {
			find(node.leftChild, 10, value);
		}

		if (node.rightChild != null) {
			find(node.rightChild, 10, value);
		}
	}

	private static void find(Node node, int value) {
		if (node == null) {
			return;
		}
		value = value * 10;
		value = value + node.data;

		if (node.leftChild == null && node.rightChild == null) {
			list.add(value);
		}

		find(node.leftChild, value);
		find(node.rightChild, value);
	}

	public static void sumNumbers(Node A) {
		find(A, 0);
		int sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		sum = (sum % 1003) % 1003;

		System.out.println(sum);
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
		Node node10 = new Node(6);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node3.rightChild = node8;
		node8.leftChild = node9;
		node8.rightChild = node10;

		/*find(root, 1, 0);
		
		int sum = 0;
		for (int i : list) {
			System.out.println(i);
			sum += i;
		}

		System.out.println(sum % 1003);*/
		
		sumNumbers(root);
	}

}
