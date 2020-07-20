package com.ds.algo.trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClosestValue {

	private int closest(TreeNode root, double target) {
		if (root == null) {
			return 0;
		}
		
		double diff = Math.abs(target - root.val);
		int min = root.val;
		TreeNode cur = root;
		
		while (cur != null) {
			
			double curDiff = Math.abs(target - cur.val);
			if (diff > curDiff) {
				diff = curDiff;
				min = cur.val;
			}			
			cur = (target < cur.val) ? cur.left : cur.right;
		}
		
		return min;
	}

	private List<Integer> closest(TreeNode root, double target, int k) {
		List<Integer> list = new LinkedList<>();
		if (root == null || k == 0) {
			return list;
		}
		
		double diff = Double.MAX_VALUE;
		TreeNode cur = root;
		
		int i = k;
		while (cur != null) {
			
			double curDiff = Math.abs(target - cur.val);
			if (diff > curDiff) {
				diff = curDiff;
				if (i <= 0) {
					list.remove(0);
				}
				list.add(cur.val);
				i--;
			}			
			cur = (target < cur.val) ? cur.left : cur.right;
		}
		
		return list;
	}
	
	
	
	
	
	static class Closest implements Comparable<Closest>{
		double diff;
		int value;
		
		public Closest(double diff, int value) {
			this.diff = diff;
			this.value = value;
		}

		@Override
		public int compareTo(Closest o) {
			return Double.compare(diff, o.diff);
		}
		
	}
	
	private List<Integer> closest2(TreeNode root, double target, int k) {
		List<Integer> list = new LinkedList<>();
		List<Closest> closestList = new ArrayList<>();
		int rr = k;
		if (root == null || k == 0) {
			return list;
		}
		traverse(root, closestList, target);
		Collections.sort(closestList);
		for (Closest c: closestList) {
			if (rr-- == 0) {
				break;
			}
			list.add(c.value);
		}
		return list;
	}
	
	private void traverse(TreeNode node, List<Closest> queue, double target) {
		if (node == null) {
			return;
		}
		
		double curDiff = Math.abs(target - node.val);
		queue.add(new Closest(curDiff, node.val));
		traverse(node.left, queue, target);
		traverse(node.right, queue, target);
	}
	
	public static void main(String[] args) {
		TreeNode node5 =  new TreeNode(5);
		TreeNode node4 =  new TreeNode(4);
		TreeNode node1 =  new TreeNode(1);
		TreeNode node3 =  new TreeNode(3);
		TreeNode node2 =  new TreeNode(2);
		TreeNode node10 =  new TreeNode(10);

		node4.left = node2;
		node4.right = node5;
		
		node2.left = node1;
		node2.right = node3;
		
		ClosestValue bst = new ClosestValue();
		
		//System.out.println("For  closest value is -> "+bst.closest(node4, 0.7));
		
		bst.closest2(node4, 3.714, 3).stream().forEach(v -> {
			System.out.print(v+" ");
		});
		/*for (int i = -10; i < 30; i++) {
			System.out.println("For "+i +" closest value is -> "+bst.closest(node5, i));
		}*/
		
	}

}
