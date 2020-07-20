package com.ds.algo.trees.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Cousins {

	private class Depth {
		int depth;
		int parent;
		
		public Depth(int depth, int parent) {
			this.parent = parent;
			this.depth = depth;
		}
	}
	
	static Map<Integer, Depth> map = new HashMap<>();

	private void setParentAndDepth(Node node, int depth) {
		if (node == null) {
			return;
		}

		if (!map.containsKey(node.data)) {
			map.put(node.data, new Depth(depth, -1));
		}

		if (node.leftChild != null) {
			if (!map.containsKey(node.leftChild.data)) {
				map.put(node.leftChild.data, new Depth(depth + 1, node.data));
			}
		}

		if (node.rightChild != null) {
			if (!map.containsKey(node.rightChild.data)) {
				map.put(node.rightChild.data, new Depth(depth + 1, node.data));
			}
		}

		setParentAndDepth(node.leftChild, depth + 1);
		setParentAndDepth(node.rightChild, depth + 1);
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

		new Cousins().setParentAndDepth(root, 0);

		map.entrySet().stream().forEach(kv -> {
			System.out.println(kv.getKey()+" -> Depth: "+kv.getValue().depth+", Parent: "+kv.getValue().parent);
		});
	}

}
