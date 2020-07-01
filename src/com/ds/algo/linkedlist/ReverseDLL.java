package com.ds.algo.linkedlist;

public class ReverseDLL {

	static DLLNode head;

	private static void reverse() {
		if (head == null) {
			System.out.println("Empty");
			return;
		}

		DLLNode temp = null;
		DLLNode cur = head;

		while (cur != null) {
			temp = cur.prev;
			cur.prev = cur.next;
			cur.next = temp;
			cur = cur.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
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
		head = new DLLNode(1);
		head.next = new DLLNode(2);
		head.next.prev = head;

		head.next.next = new DLLNode(3);
		head.next.next.prev = head.next;

		head.next.next.next = new DLLNode(4);
		head.next.next.next.prev = head.next.next;
		print();
		reverse();
		print();
	}

}
