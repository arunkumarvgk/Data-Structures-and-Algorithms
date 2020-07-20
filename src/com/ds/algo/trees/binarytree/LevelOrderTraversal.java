package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
		levelOrder(root);
	}

	private static void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data+" ");
			if (temp.leftChild != null) {
				queue.add(temp.leftChild);
			}
			
			if (temp.rightChild != null) {
				queue.add(temp.rightChild);
			}
		}
		
	}

}
