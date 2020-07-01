package com.ds.algo.linkedlist;

public class PairWiseSwap {
	static SLLNode head;

	private static void swap() {
		if (head == null) {
			System.out.println("Empty");
			return;
		}

		SLLNode a = head;
		if (head.next == null) {
			System.out.println("Only one element");
			return;
		}
		SLLNode b = head.next;
		//SLLNode start = b;
		while (a != null && b != null) {
			int temp = a.data;
			a.data = b.data;
			b.data = temp;

			a = a.next.next;

			if (a != null) {
				b = a.next;
			}
		}

		//head = start;
	}

	private static void print() {
		SLLNode node = head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		head.next.next.next.next.next = new SLLNode(6);
		head.next.next.next.next.next.next = new SLLNode(7);
		head.next.next.next.next.next.next.next = new SLLNode(8);
		head.next.next.next.next.next.next.next.next = new SLLNode(9);
		head.next.next.next.next.next.next.next.next.next = new SLLNode(10);
		print();
		swap();
		print();
	}

}
