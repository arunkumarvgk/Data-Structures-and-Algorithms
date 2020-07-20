package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

public class PrintTopView {

	private static void topView(Node node, int distance, int level, Map<Integer, Pair<Integer, Integer>> treeMap) {
		if (node == null) {
			return;
		}

		// If it is a new distance or the distance exists but lower level then update
		if (!treeMap.containsKey(distance)
				|| (treeMap.containsKey(distance) && treeMap.get(distance).getValue() > level)) {
			treeMap.put(distance, new Pair<>(node.data, level));
		}

		topView(node.leftChild, distance - 1, level + 1, treeMap);
		topView(node.rightChild, distance + 1, level + 1, treeMap);
	}

	private static void bottomView(Node node, int distance, int level,
			Map<Integer, List<Pair<Integer, Integer>>> treeMap) {
		if (node == null) {
			return;
		}

		// If it is a new distance or the distance exists but higher level then update

		if (!treeMap.containsKey(distance)) {
			List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
			list.add(new Pair<>(node.data, level));
			treeMap.put(distance, list);
		} else if ((treeMap.containsKey(distance))) {
			List<Pair<Integer, Integer>> list = treeMap.get(distance);

			if (level == list.get(0).getValue()) {
				list.add(new Pair<>(node.data, level));
			}

			if (level > list.get(0).getValue()) {
				list.clear();
				list.add(new Pair<>(node.data, level));
			}
			treeMap.put(distance, list);
		}

		bottomView(node.leftChild, distance - 1, level + 1, treeMap);
		bottomView(node.rightChild, distance + 1, level + 1, treeMap);
	}

	private static void print(Map<Integer, Pair<Integer, Integer>> treeMap) {
		treeMap.entrySet().stream().forEach(kv -> {
			System.out.print(kv.getValue().getKey() + " ");
		});
		System.out.println();
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

		Map<Integer, Pair<Integer, Integer>> treeMapTop = new TreeMap<>();
		topView(root, 0, 0, treeMapTop);
		print(treeMapTop);

		Map<Integer, List<Pair<Integer, Integer>>> treeMapBottom = new TreeMap<>();
		bottomView(root, 0, 0, treeMapBottom);
		treeMapBottom.entrySet().stream().forEach(kv -> {
			kv.getValue().forEach(nkv -> {
				System.out.print(nkv.getKey() + " ");
			});
		});
	}

}
