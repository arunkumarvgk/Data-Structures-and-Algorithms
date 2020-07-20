package com.ds.algo.trees.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConvertInorderPreorderToBT {

	static int index = 0;
	static int index2 = 0;
	static Map<Integer, Integer> map = new HashMap<>();

	private static Node makeBT(int inorder[], int preorder[], int start, int end) {
		if (start > end) {
			return null;
		}

		Node node = new Node(preorder[index++]);

		if (start == end) {
			return node;
		}

		int inorderIndex = getInorderIndex(inorder, start, end, node.data);
		node.leftChild = makeBT(inorder, preorder, start, inorderIndex - 1);
		node.rightChild = makeBT(inorder, preorder, inorderIndex + 1, end);
		return node;
	}

	private static int getInorderIndex(int[] inorder, int start, int end, int value) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == value) {
				return i;
			}
		}
		return -1;
	}

	private static Node makeBT2(int inorder[], int preorder[], int start, int end) {
		if (start > end) {
			return null;
		}
		
		//Create nodes looping through preorder array
		Node node = new Node(preorder[index2]);
		int inorderIndex = map.get(preorder[index2++]);
		if (start == end) {
			return node;
		}
		
		node.leftChild = makeBT2(inorder, preorder, start, inorderIndex - 1);
		node.rightChild = makeBT2(inorder, preorder, inorderIndex + 1, end);
		return node;
		
	}

	public static void main(String[] args) {
		int inorder[] = new int[] { 2, 5, 6, 10, 12, 14, 16 };
		int preorder[] = new int[] { 10, 5, 2, 6, 14, 12, 16 };
		int index = 0;
		for (int i : inorder) {
			map.put(i, index++);
		}
		Node node = makeBT2(inorder, preorder, 0, inorder.length - 1);
		print(node);
	}

	private static void print(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.leftChild != null) {
				queue.add(temp.leftChild);
			}

			if (temp.rightChild != null) {
				queue.add(temp.rightChild);
			}
		}
		
		System.out.println();
	}
}
