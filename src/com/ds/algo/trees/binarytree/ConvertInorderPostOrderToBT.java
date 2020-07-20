package com.ds.algo.trees.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConvertInorderPostOrderToBT {

	static Map<Integer, Integer> map = new HashMap<>();

	private static Node makeBT(int inorder[], int postorder[], int istart, int iend, int pstart, int pend) {

		if (istart > iend || pstart > pend) {
			return null;
		}

		Node node = new Node(postorder[pend]);

		if (istart == iend) {
			return node;
		}

		int inorderIndex = map.get(node.data);
		// 0123 4 567
		int lss = inorderIndex - istart;
		int rss = iend - inorderIndex;

		node.leftChild = makeBT(inorder, postorder, istart, inorderIndex - 1, pend - rss - lss, pend - rss - 1);
		node.rightChild = makeBT(inorder, postorder, inorderIndex + 1, iend, pend - rss, pend - 1);
		return node;
	}

	private static Node makeBT2(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
		if (istart > iend || pstart > pend) {
			return null;
		}

		Node node = new Node(postorder[pend]);

		if (istart == iend) {
			return node;
		}

		int inorderIndex = map.get(node.data);
		int lss = inorderIndex - istart;
		int rss = iend - inorderIndex;

		node.leftChild = makeBT(inorder, postorder, istart, inorderIndex - 1, pend - rss - lss, pend - rss - 1);
		node.rightChild = makeBT(inorder, postorder, inorderIndex + 1, iend, pend - rss, pend - 1);
		return node;
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

	public static void main(String[] args) {
		int inorder[] = { 9, 3, 15, 20, 7 };
		int postorder[] = { 9, 15, 7, 20, 3 };

		for (int i = 0; i < postorder.length; i++) {
			map.put(inorder[i], i);
		}
		print(makeBT2(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1));
		print(buildTree(inorder, postorder));
	}

	/*
	 in: 9, 3, 15, 20, 7 -> 20, 3 is the end point to seperate lefr subtree and right subtree
	 
	 po: 9, 15, 7, 20, 3 -> 3 and 20 is root since post order
	 
	 base on root, we want to find the end point to get left and right substree

	*/
	
	public static int inindex;
	public static int postindex;

	public static Node buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null)
			return null;

		inindex = inorder.length - 1;
		postindex = postorder.length - 1;

		return dfs(inorder, postorder, null, inindex, postindex);
	}

	private static Node dfs(int[] inorder, int[] postorder, Node prevInStack, int inindex, int postindex) {
		if (inindex < 0 || postindex < 0)
			return null;

		// root
		Node root = new Node(postorder[postindex--]);

		// this condition fails when ter is no right child
		if (inorder[inindex] != root.data) {
			root.rightChild = dfs(inorder, postorder, root, inindex, postindex);
		}
		inindex--;

		//prevIn stack will be null wehn we complere all the right child of root
		if ((prevInStack == null) || (inorder[inindex] != prevInStack.data)) {
			root.leftChild = dfs(inorder, postorder, prevInStack, inindex, postindex);
		}

		return root;
	}
}