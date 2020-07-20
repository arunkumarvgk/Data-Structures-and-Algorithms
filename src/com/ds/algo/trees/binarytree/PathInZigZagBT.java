package com.ds.algo.trees.binarytree;

import java.util.LinkedList;
import java.util.List;

public class PathInZigZagBT {

	public List<Integer> pathInZigZagTree(int label) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(label);

		while (label > 1) {
			int level = (int)(Math.log(label)/Math.log(2)) + 1;
			int maxInLevel = (int) Math.pow(2, level) - 1;
			int minInLevel = (int) Math.pow(2, level - 1);
			label = (maxInLevel + minInLevel - label) / 2;
			list.addFirst(label);
		}

		return list;
	}

	public static void main(String[] args) {
		PathInZigZagBT bt = new PathInZigZagBT();
		bt.pathInZigZagTree(30).stream().forEach(v -> System.out.println(v));
	}

}
