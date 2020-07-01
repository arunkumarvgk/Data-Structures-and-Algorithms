package com.ds.algo.linkedlist;

public class RotateDLLBynNodes {

	static DLLNode head;
	static DLLNode tail;

	private static void rotate(int n) {
		DLLNode temp = head;
		DLLNode temp2;
		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}

		temp2 = temp.prev;
		temp.prev = null;
		tail.next = head;
		head.prev = tail;
		temp2.next = null;
		
		head= temp;
	}

	private static void print() {
		DLLNode cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DLLNode node1 = new DLLNode(1);
		DLLNode node2 = new DLLNode(2);
		DLLNode node3 = new DLLNode(3);
		DLLNode node4 = new DLLNode(4);
		DLLNode node5 = new DLLNode(5);
		DLLNode node6 = new DLLNode(6);
		DLLNode node7 = new DLLNode(7);
		DLLNode node8 = new DLLNode(8);
		DLLNode node9 = new DLLNode(9);
		DLLNode node10 = new DLLNode(10);

		node1.prev = null;
		node1.next = node2;

		node2.prev = node1;
		node2.next = node3;

		node3.prev = node2;
		node3.next = node4;

		node4.prev = node3;
		node4.next = node5;

		node5.prev = node4;
		node5.next = node6;

		node6.prev = node5;
		node6.next = node7;

		node7.prev = node6;
		node7.next = node8;

		node8.prev = node7;
		node8.next = node9;

		node9.prev = node8;
		node9.next = node10;

		node10.prev = node9;
		node10.next = null;

		head = node1;
		tail = node10;

		print();
		
		rotate(2);
		
		print();
	}

}
