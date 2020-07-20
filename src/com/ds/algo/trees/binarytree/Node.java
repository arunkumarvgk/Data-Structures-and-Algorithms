package com.ds.algo.trees.binarytree;

public class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;

	public Node(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
			
	public Node(int data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}