package com.ds.algo.trees.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperations {
	TreeNode head = null;

	private TreeNode search(int val) {
		if (head == null || head.val == val) {
			return head;
		}
		
		TreeNode cur = head;
		while (cur != null && cur.val != val) {
			cur = cur.val > val ? cur.left : cur.right;
		}
		
		return cur;
	}

	private void insert(int val) {
		TreeNode node = new TreeNode(val);

		/** Set head if head is null */
		if (head == null) {
			head = node;
			return;
		}

		TreeNode cur = head;
		TreeNode prev = null;
		while (cur != null) {
			prev = cur;
			cur = ( node.val < cur.val ) ? cur.left : cur.right; 
		}

		if (node.val < prev.val) {
			prev.left = node;
		} else {
			prev.right = node;
		}
	}

	private void print() {
		if (head == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(head);

		while (!queue.isEmpty()) {
			int length = queue.size();
			while (length-- != 0) {
				TreeNode temp = queue.poll();
				System.out.print(temp.val + " ");

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println();
		}
	}

	private void deleteNode(int val) {
		if (head == null) {
			return;
		}
		
		TreeNode cur = head;
		TreeNode prev = null;
		while (cur != null && cur.val != val) {
			prev = cur;
			if (cur.val > val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		
		if (cur == null) {
			// Node not found
			return;
		}
		
		if (cur.left == null && cur.right == null) {
			//If node has no children
			if (prev.left == cur) {
				prev.left = null;
			} else {
				prev.right = null;
			}
		} else if (cur.left != null && cur.right != null) {
			TreeNode temp = cur.left;
			while (temp.right != null) {
				prev = temp;
				temp = temp.right;
			}
			cur.val = temp.val;
			
			if (prev == cur) {
				prev.left = temp.left;
			} else {
				prev.right = temp.left;
			}
			
		} else {
			//If node has only one child
			if (cur.left != null) {
				if (prev.left == cur) {
					prev.left = cur.left;
				} else {
					prev.right = cur.left;
				}
			} else {
				if (prev.left == cur) {
					prev.left = cur.right;
				} else {
					prev.right = cur.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		BasicOperations bst = new BasicOperations();
		bst.insert(13);
		bst.insert(3);
		bst.insert(4);
		bst.insert(12);
		bst.insert(14);
		bst.insert(10);
		bst.insert(5);
		bst.insert(1);
		bst.insert(8);
		bst.insert(2);
		bst.insert(7);
		bst.insert(9);
		bst.insert(11);
		bst.insert(6);
		bst.insert(18);
		
		bst.print();
		
		TreeNode searchedNode = bst.search(5);
		System.out.println(searchedNode == null ? "Node not found" : "Node found");
		searchedNode = bst.search(6);
		System.out.println(searchedNode == null ? "Node not found" : "Node found");
		searchedNode = bst.search(51);
		System.out.println(searchedNode == null ? "Node not found" : "Node found");
		searchedNode = bst.search(67);
		System.out.println(searchedNode == null ? "Node not found" : "Node found");
		
		System.out.println("++++++++++++++++++++++++++++++");
		
		System.out.println("Delete 10");
		bst.deleteNode(10);
		bst.print();

		System.out.println("Delete 13");
		bst.deleteNode(13);
		bst.print();
		
		System.out.println("Delete 4");
		bst.deleteNode(4);
		bst.print();
		System.out.println("Delete 2");
		bst.deleteNode(2);
		bst.print(); 
		
	}

}
