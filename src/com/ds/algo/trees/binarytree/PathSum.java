package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {
	static List<Integer> list = new ArrayList<>();
	static List<List<Integer>> listlist = new ArrayList<>();

	static Stack<Integer> path = new Stack<Integer>();

	private static void checkSum(Node node, int sum) {
		if (node == null) {
			return;
		}
		sum = sum - node.data;
		path.push(node.data);

		if (node.leftChild == null && node.rightChild == null && sum == 0) {
			listlist.add(new ArrayList<Integer>(path));
		}

		checkSum(node.leftChild, sum);
		checkSum(node.rightChild, sum);
		path.pop();
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node2 = new Node(4);
		Node node3 = new Node(8);
		Node node4 = new Node(11);
		Node node5 = new Node(13);
		Node node6 = new Node(4);
		Node node7 = new Node(2);
		Node node8 = new Node(2);
		Node node9 = new Node(5);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;

		node3.leftChild = node5;
		node3.rightChild = node6;

		node4.leftChild = node7;
		node4.rightChild = node8;

		node6.rightChild = node9;

		checkSum(root, 22);

		listlist.stream().forEach(v -> {
			v.stream().forEach(vv -> System.out.print(vv + " "));
			System.out.println();
		});
	}

}
