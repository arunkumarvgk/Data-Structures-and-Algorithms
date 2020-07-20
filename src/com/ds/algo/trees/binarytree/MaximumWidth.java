package com.ds.algo.trees.binarytree;

import java.util.HashMap;
import java.util.Map;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class MaximumWidth {

	int ans = 0;
	Map<Integer, Integer> map = new HashMap<>();
	
	private int maxWidth(TreeNode root) {
		dfs(root, 0, 0);
		return ans;
	}
	
	void dfs(TreeNode node, int depth, int position) {
		if (node == null) {
			return;
		}
		map.computeIfAbsent(depth, x -> position);
		ans = Math.max(ans, position - map.get(depth) + 1);
		dfs(node.left, depth + 1, 2 * position);
		dfs(node.right, depth + 1, 2 * position + 1);
	}
	
	
	/**
	 *              1
	 *            /   \
	 *          2        3
	 *        /   \        \
	 *      4       5        8
	 *            /  \      /  \
	 *           6    7   9      10
	 *           
	 *           
	 * width include [6,7,n,n,9,10] that is 6
	 * map will have the position(level wise) of first node in each depth
	 * depth 0 first node 1 pos(0)
	 * depth 1 first node 2 pos(0)
	 * depth 2 first node 4 pos(0)
	 * depth 3 first node 5 pos(2) bcoz node 4 doesn't have l,r(0, 1)
	 * 
	 * cal answer example 10 last one pos = 7, depth = 3 and first node position in that depth is 2
	 * 
	 * so ans = curPos - positionOfFirstNodeInThisdepth + 1
	 * ans = 7 - 2 + 1 = 6
	 * 
	 */
	public static void main(String[] args) {
		
		MaximumWidth bt = new MaximumWidth();
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node6;
		node5.right = node7;

		node3.right = node8;
		node8.left = node9;
		node8.right = node10;
		
		System.out.println(bt.maxWidth(root));
	}

}
