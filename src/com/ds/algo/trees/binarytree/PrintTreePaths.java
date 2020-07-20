package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintTreePaths {
	static List<String> list = new ArrayList<>();
	static Stack<Node> stack = new Stack<>();

	private static void path(Node node) {
		if (node == null) {
			return;
		}
		
		stack.push(node);
		if (node.leftChild == null && node.rightChild == null) {
			String s = new String();
			if (stack.size() > 1) {
				for(Node n: stack) {
					s= s+n.data+"->";
				}
				list.add(s.substring(0, s.length()-2));
			}
		}
		
		path(node.leftChild);
		path(node.rightChild);
		stack.pop();
	}

	public static List<String> traverse(Node node, String str, List<String> list) {
		str += Integer.toString(node.data);
		str += "->";
		if (node.leftChild == null && node.rightChild == null) {
			str = str.substring(0, str.length() - 2);
			list.add(str);
		}

		if (node.leftChild != null)
			traverse(node.leftChild, str, list);

		if (node.rightChild != null)
			traverse(node.rightChild, str, list);

		return list;
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
		Node node10 = new Node(10);

		root.leftChild = node2;
		root.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node5.leftChild = node6;
		node5.rightChild = node7;

		node3.rightChild = node8;
		node8.leftChild = node9;

		//path(root);
		list = traverse(root, new String(), list);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
