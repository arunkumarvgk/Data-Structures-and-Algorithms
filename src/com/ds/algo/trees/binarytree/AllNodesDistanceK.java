package com.ds.algo.trees.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class AllNodesDistanceK {

	Map<TreeNode, TreeNode> map = new HashMap<>();

	private List<Integer> find(TreeNode node, TreeNode target, int k) {
		List<Integer> list = new ArrayList<>();

		dfs(node, null);

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(target);

		Set<TreeNode> set = new HashSet<>();
		set.add(target);

		int distance = 0;
		while (!queue.isEmpty()) {
			if (distance == k) {
				list = new ArrayList<>();
				for (TreeNode n: queue) {
					list.add(n.val);
				}
				return list;
			} else {
				int length =  queue.size();
				while (length-- != 0) {
					TreeNode temp = queue.poll();
					
					if ( temp.left != null && ! set.contains(temp.left)) {
						set.add(temp.left);
						queue.add(temp.left);
					}
					
					if (temp.right != null && ! set.contains(temp.right)) {
						set.add(temp.right);
						queue.add(temp.right);
					}
					
					if (map.get(temp) != null && ! set.contains(map.get(temp))) {
						set.add(map.get(temp));
						queue.add(map.get(temp));
					}
				}
				distance++;
			}
		}
		return list;
	}

	private void dfs(TreeNode node, TreeNode parent) {
		if (node == null) {
			return;
		}
		map.put(node, parent);
		dfs(node.left, node);
		dfs(node.right, node);
	}

	public static void main(String[] args) {
		AllNodesDistanceK bt = new AllNodesDistanceK();
		
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node3.left = node5;
		node3.right = node1;
		
		node5.left = node6;
		node5.right = node2;
		
		node2.left = node7;
		node2.right = node4;
		
		List<Integer> list = bt.find(node3, node5, 2);
		
		list.forEach(n ->  System.out.print(n+" "));
	}

}
