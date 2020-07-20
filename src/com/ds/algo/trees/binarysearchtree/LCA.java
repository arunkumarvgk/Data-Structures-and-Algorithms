package com.ds.algo.trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class LCA {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pAncestors = new ArrayList<>();
		List<TreeNode> qAncestors = new ArrayList<>();

		search(root, pAncestors, p);
		search(root, qAncestors, q);

		int min = (pAncestors.size() > qAncestors.size()) ? qAncestors.size() : pAncestors.size();
		int i = 0;

		for (; i < min; i++) {
			if (pAncestors.get(i) != qAncestors.get(i)) {
				break;
			}
		}

		return pAncestors.get(--i);
	}

	private void search(TreeNode node, List<TreeNode> list, TreeNode key) {
		list.add(node);
		while (node != null && node.val != key.val) {
			node = node.val > key.val ? node.left : node.right;
			list.add(node);
		}
	}
	
	private TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {		
		if (node == null) {
			return node;
		}
		if (node.val > p.val && node.val > q.val) {
			return lca(node.left, p, q);
		} else if (node.val < p.val && node.val < q.val) {
			return lca(node.right, p, q);
		} else {
			return node;
		}
	}

	private TreeNode lcaIterative(TreeNode node, TreeNode p, TreeNode q) {		
		while (node != null) {
			if (node.val > p.val && node.val > q.val) {
				node = node.left;
			} else if (node.val < p.val && node.val < q.val) {
				node = node.right;
			} else {
				return node;
			}
		}
		return node;
	}
	public static void main(String[] args) {

		LCA lca = new LCA();
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

		node6.left = node2;
		node6.right = node8;

		node2.left = node0;
		node2.right = node4;

		node4.left = node3;
		node4.right = node5;

		node8.left = node7;
		node8.right = node9;

		System.out.println(lca.lowestCommonAncestor(node6, new TreeNode(2), new TreeNode(8)).val);
	}

}
