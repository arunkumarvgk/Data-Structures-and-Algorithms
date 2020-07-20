package com.ds.algo.trees.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class NodeP {
	int data;
	NodeP leftChild;
	NodeP rightChild;
	NodeP parent;

	public NodeP(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public NodeP(int data, NodeP leftChild, NodeP rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public static void addLeft(NodeP parent, NodeP child) {
		parent.leftChild = child;
		child.parent = parent;
	}

	public static void addRight(NodeP parent, NodeP child) {
		parent.rightChild = child;
		child.parent = parent;
	}
}

public class LowestCommonAncestor {

	private static NodeP getLowestCommonAncestor(NodeP root, NodeP node1, NodeP node2) {
		if (root == null) {
			return null;
		}

		if (root == node1 || root == node2) {
			return root;
		}

		NodeP left = getLowestCommonAncestor(root.leftChild, node1, node2);
		NodeP right = getLowestCommonAncestor(root.rightChild, node1, node2);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right : left;
	}

	private static boolean findIfAvailableInTree(NodeP node, int val) {
		if (node == null) {
			return false;
		}
		Queue<NodeP> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			NodeP temp = queue.poll();
			if (temp.data == val) {
				return true;
			}

			if (temp.leftChild != null) {
				queue.add(temp.leftChild);
			}

			if (temp.rightChild != null) {
				queue.add(temp.rightChild);
			}
		}
		return false;
	}

	private static NodeP lca(NodeP root, NodeP node1, NodeP node2) {
		Set<NodeP> set = new HashSet<>();
		NodeP lca = null;

		NodeP temp = node1;
		set.add(temp);

		while (temp.parent != null) {
			set.add(temp.parent);
			temp = temp.parent;
		}

		temp = node2;
		while (temp != null) {
			if (set.contains(temp)) {
				lca = temp;
				break;
			}
			temp = temp.parent;
		}

		return lca;
	}

	public static void main(String[] args) {
		NodeP root = new NodeP(1);
		NodeP node2 = new NodeP(2);
		NodeP node3 = new NodeP(3);
		NodeP node4 = new NodeP(4);
		NodeP node5 = new NodeP(5);
		NodeP node6 = new NodeP(6);
		NodeP node7 = new NodeP(7);
		NodeP node8 = new NodeP(8);
		NodeP node9 = new NodeP(9);

		NodeP.addLeft(root, node2);
		NodeP.addRight(root, node3);

		NodeP.addLeft(node2, node4);
		NodeP.addRight(node2, node5);

		NodeP.addLeft(node5, node7);
		NodeP.addRight(node5, node8);

		if (findIfAvailableInTree(root, 8) && findIfAvailableInTree(root, 8)) {
			NodeP d = getLowestCommonAncestor(root, node9, node8);
			if (d == null) {
				System.out.println("Null");
			} else {
				System.out.println(d.data);
			}
		} else {
			System.out.println("Null");
		}

		//System.out.println(getLowestCommonAncestor(root, node9, node8).data);
		// System.out.println(lca(root, node9, node9).data);
	}

}
