package com.ds.algo.trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestValue2 {

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<Integer>();

		Stack<TreeNode> successors = new Stack<TreeNode>();
		Stack<TreeNode> predecessors = new Stack<TreeNode>();

		while (root != null) {
			if (root.val >= target) {
				successors.push(root);
				root = root.left;
			} else if (root.val < target) {
				predecessors.push(root);
				root = root.right;
			}
		}

		while (k > 0 && (!successors.isEmpty() || !predecessors.isEmpty())) {
			if (successors.isEmpty()) {
				res.add(getNextPredecessor(predecessors));
			} else if (predecessors.isEmpty()) {
				res.add(getNextSuccessor(successors));
			} else {
				if (Math.abs(predecessors.peek().val - target) > Math.abs(successors.peek().val - target)) {
					res.add(getNextSuccessor(successors));
				} else {
					res.add(getNextPredecessor(predecessors));
				}
			}
			k--;
		}

		return res;
	}

	private int getNextSuccessor(Stack<TreeNode> stack) {
		TreeNode node = stack.pop();
		TreeNode next = node.right;
		while (next != null) {
			stack.push(next);
			next = next.left;
		}
		return node.val;
	}

	private int getNextPredecessor(Stack<TreeNode> stack) {
		TreeNode node = stack.pop();
		TreeNode next = node.left;
		while (next != null) {
			stack.push(next);
			next = next.right;
		}
		return node.val;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(17);
		TreeNode node5 = new TreeNode(18);
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(23);

		node1.left = node2;
		node1.right = node3;

		node3.left = node4;
		node3.right = node7;

		node4.left = node6;
		node4.right = node5;
		
		node7.left =  new TreeNode(22);

		ClosestValue2 bst = new ClosestValue2();
		bst.closestKValues(node1, 21, 3).stream().forEach(v -> {
			System.out.print(v + " ");
		});
	}

}
