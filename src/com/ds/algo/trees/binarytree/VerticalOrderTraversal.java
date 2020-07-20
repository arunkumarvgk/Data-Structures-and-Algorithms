package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Axis {
	int x;
	int y;

	public Axis(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class AxisComparator implements Comparator<Axis> {

	@Override
	public int compare(Axis o1, Axis o2) {
		if (o1.x > o2.x) {

			return 1;
		}
		return -1;
	}

}

public class VerticalOrderTraversal {

	private static void verticalOrder(Node node, int level, Map<Integer, List<Node>> treeMap) {
		if (node != null) {
			addToMap(node, level, treeMap);
			verticalOrder(node.leftChild, level - 1, treeMap);
			verticalOrder(node.rightChild, level + 1, treeMap);
		}
	}

	private static void addToMap(Node node, int level, Map<Integer, List<Node>> treeMap) {
		List<Node> nodes;
		if (treeMap.containsKey(level)) {
			nodes = treeMap.get(level);
			nodes.add(node);
		} else {
			nodes = new ArrayList<>();
			nodes.add(node);
		}
		treeMap.put(level, nodes);
	}

	private static void print(Map<Integer, List<Node>> treeMap) {
		treeMap.entrySet().stream().forEach(kv -> {
			System.out.print(kv.getKey() + " :: ");
			kv.getValue().stream().forEach(node -> {
				System.out.print(node.data + " ");
			});
			System.out.println();
		});
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
		node8.rightChild = node10;

		Map<Integer, List<Node>> treeMap = new TreeMap<>();
		verticalOrder(root, 0, treeMap);
		print(treeMap);
		//		verticalOrder2();
	}

	private static void verticalOrder2() {
		NodeV root = new NodeV(1);
		NodeV node2 = new NodeV(2);
		NodeV node3 = new NodeV(3);
		NodeV node4 = new NodeV(4);
		NodeV node5 = new NodeV(5);
		NodeV node6 = new NodeV(6);
		NodeV node7 = new NodeV(7);
		NodeV node8 = new NodeV(8);
		NodeV node9 = new NodeV(9);
		NodeV node10 = new NodeV(10);

		root.leftChild = node2;
		root.rightChild = node3;

		// node2.leftChild = node4;
		// node2.rightChild = node5;

		// node5.leftChild = node6;
		// node5.rightChild = node7;

		node3.leftChild = node4;
		node3.rightChild = node5;
		// node8.leftChild = node9;
		// node8.rightChild = node10;

		Map<Axis, List<NodeV>> treeMap = new TreeMap<>(new AxisComparator());
		verticalOrder(root, 0, 0, treeMap);
		print2(treeMap);
	}

	private static void verticalOrder(NodeV node, int x, int y, Map<Axis, List<NodeV>> treeMap) {
		if (node != null) {
			addToMap(node, x, y, treeMap);
			verticalOrder(node.leftChild, x - 1, y - 1, treeMap);
			verticalOrder(node.rightChild, x + 1, y - 1, treeMap);
		}
	}

	private static void addToMap(NodeV node, int x, int y, Map<Axis, List<NodeV>> treeMap) {
		List<NodeV> nodes = null;
		Axis axis = null;

		for (Entry<Axis, List<NodeV>> entry : treeMap.entrySet()) {
			axis = entry.getKey();
			if (axis.x == x && axis.y == y) {
				nodes = entry.getValue();
				break;
			}
		}

		if (nodes != null) {
			nodes.add(node);
			treeMap.replace(axis, nodes);
		} else {
			nodes = new ArrayList<>();
			nodes.add(node);
			treeMap.put(new Axis(x, y), nodes);
		}

	}

	private static void print2(Map<Axis, List<NodeV>> treeMap) {
		Map<Integer, List<NodeV>> map = new TreeMap<>();
		treeMap.entrySet().stream().forEach(kv -> {
			kv.getValue().stream().forEach(node -> {
				List<NodeV> nodes = new ArrayList<>();
				if (map.containsKey(kv.getKey().x)) {
					nodes = map.get(kv.getKey().x);
				}
				nodes.add(node);
				map.put(kv.getKey().x, nodes);
			});
		});
		
			map.entrySet().stream().forEach(kv -> {
			System.out.print(kv.getKey()+" ");
			kv.getValue().stream().forEach(v -> System.out.print(v.data+" "));
			System.out.println();
		});
	}
}

class NodeV implements Comparable<NodeV> {
	public int data;
	public NodeV leftChild;
	public NodeV rightChild;

	public NodeV(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public NodeV(int data, NodeV leftChild, NodeV rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public int compareTo(NodeV o) {
		return this.data < o.data ? 1 : -1;
	}
}
