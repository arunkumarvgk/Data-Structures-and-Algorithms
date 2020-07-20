package com.ds.algo.trees.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class ReverseLevelOrder {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
		levelOrderBottom(root, 0, results);
		return results;
	}

	public void levelOrderBottom(TreeNode root, int level, List<List<Integer>> results) {
		if (root == null)
			return;
		if (level >= results.size())
			results.add(0, new ArrayList<>());

		results.get(results.size() - 1 - level).add(root.val);
		levelOrderBottom(root.left, level + 1, results);
		levelOrderBottom(root.right, level + 1, results);
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> ll = new LinkedList<>();
		if (root == null) {
			return ll;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int length = queue.size();
			List<Integer> list = new ArrayList<>();

			while (length-- != 0) {
				TreeNode node = queue.poll();
				list.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
			ll.add(list);
		}

		Collections.reverse(ll);
		return ll;
	}
	
	public static void main(String[] args) {

		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node3.left = node9;
		node3.right = node8;
		
		node8.left = node7;
		node8.right = node6;
		
		List<List<Integer>> ll =  new ReverseLevelOrder().levelOrderBottom(node3);
		
		ll.stream().forEach(v -> {
			v.forEach(vv -> {
				System.out.print(vv+" ");
			});
			System.out.println();
		});
	}
}
