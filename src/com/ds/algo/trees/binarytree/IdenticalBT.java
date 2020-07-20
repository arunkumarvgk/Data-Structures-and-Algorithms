package com.ds.algo.trees.binarytree;

public class IdenticalBT {

	private static boolean find(Node node1, Node node2) {

		if (node1 == null && node2== null) {
			return true;
		}
		
		if (node1 == null && node2!= null || node1 != null && node2 == null) {
			return false;
		}
		
		if (node1.data == node2.data) {
			return find(node1.leftChild, node2.leftChild) && find(node1.rightChild, node2.rightChild);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Node root1 = new Node(1);

		Node node12 = new Node(2);
		Node node13 = new Node(3);
		Node node14 = new Node(4);
		Node node15 = new Node(5);
		Node node16 = new Node(6);
		Node node17 = new Node(7);
		Node node18 = new Node(8);

		root1.leftChild = node12;
		root1.rightChild = node13;

		node12.leftChild = node14;
		node12.rightChild = node18;

		node13.rightChild = node15;

		node15.leftChild = node16;
		node15.rightChild = node17;

		Node root2 = new Node(1);

		Node node22 = new Node(2);
		Node node23 = new Node(3);
		Node node24 = new Node(4);
		Node node25 = new Node(5);
		Node node26 = new Node(6);
		Node node27 = new Node(7);
		Node node28 = new Node(8);

		root2.leftChild = node22;
		root2.rightChild = node23;

		node22.leftChild = node24;
		node22.rightChild = node28;

		node23.rightChild = node25;

		node25.leftChild = node26;
		node25.rightChild = node27;

		System.out.println(find(root1, root2));
	}

}
