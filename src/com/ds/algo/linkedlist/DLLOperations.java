package com.ds.algo.linkedlist;

public class DLLOperations {
	static DLLNode head;

	private static void insertFront(int data) {
		DLLNode node = new DLLNode(data);
		if (head == null) {
			head = node;
			return;
		}

		node.next = head;
		head.prev = node;
		head = node;
	}

	private static void insertLast(int data) {
		DLLNode node = new DLLNode(data);
		if (head == null) {
			head = node;
			return;
		}

		DLLNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}

		cur.next = node;
		node.prev = cur;
	}

	private static void insertAtPos(int pos, int data) {
		if (pos == 0) {
			insertFront(data);
			return;
		}

		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		DLLNode cur = head;

		while (pos != -1 && cur.next != null) {
			pos--;
			cur = cur.next;
		}

		if (cur == null || pos == -1) {
			System.out.println("Invalid Position");
			return;
		}

		DLLNode node = new DLLNode(data);
		cur.prev.next = node;
		node.prev = cur.prev;

		cur.prev = node;
		node.next = cur;
	}

	private static void deleteFirst() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		head = head.next;
		head.prev = null;
	}

	private static void deleteLast() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		DLLNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur = cur.prev;
		cur.next = null;
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
		insertFront(1);
		insertLast(3);
		print();
		insertAtPos(1, 2);
		print();
		insertLast(4);
		insertLast(5);
		insertLast(6);
		print();
		insertAtPos(0, 0);
		print();
		deleteFirst();
		deleteLast();
		print();

	}

}
