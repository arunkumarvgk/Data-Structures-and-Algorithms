package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	List<Integer> aAncestors = new ArrayList<>();
	List<Integer> bAncestors = new ArrayList<>();
	Map<Integer, Integer> map = new HashMap<>();

	private void calcParent(Node node) {
		if (node.leftChild != null) {
			map.put(node.leftChild.data, node.data);
			calcParent(node.leftChild);
		}

		if (node.rightChild != null) {
			map.put(node.rightChild.data, node.data);
			calcParent(node.rightChild);
		}
	}

	private void findAncetorsListA(int B) {
		aAncestors.add(B);
		while (map.get(B) != null) {
			int parent = map.get(B);
			aAncestors.add(parent);
			B = parent;
		}
	}
	
	private void findAncetorsListB(int B) {
		bAncestors.add(B);
		while (map.get(B) != null) {
			int parent = map.get(B);
			bAncestors.add(parent);
			B = parent;
		}
	}

	public int lca(Node A, int B, int C) {
		int lca = -1;
		calcParent(A);
		findAncetorsListA(B);
		findAncetorsListB(C);

		int alength = aAncestors.size() - 1;
		int blength = bAncestors.size() - 1;

		if (alength == 0 && map.get(0) == null) {
			return -1;
		}

		while (alength != -1 && blength != -1) {
			if (aAncestors.get(alength) == bAncestors.get(blength)) {
				lca = bAncestors.get(blength);
				blength--;
				alength--;
			} else {
				break;
			}
		}

		return lca;
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

		node5.leftChild = node7;
		node5.rightChild = node8;

		System.out.println(new Solution().lca(root, 12, 12));
	}
}