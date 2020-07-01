package com.ds.algo.linkedlist;

public class DLLSwapKthNodeFromStartAndEnd {
	static DLLNode head;
	static DLLNode tail;

	private static void swap(int n) {
		DLLNode ch = head;
		DLLNode ct = tail;

		//swap head and tail
		if (n == 0) {
			DLLNode temp = new DLLNode(ch.data);
			temp.next = ch.next;
			
			ch.next.prev = ct;
			ch.prev = ct.prev;
			ch.next = null;
			
			ct.prev.next = ch;
			ct.next = temp.next;
			ct.prev = null;
			head = ct;
			return;
		}
		
		while (n != 0) {
			ch = ch.next;
			ct = ct.prev;
			n--;
		}
		
		if (ch == ct) {
			System.out.println("Both are same");
			return;
		}
		
		DLLNode temp = new DLLNode(ch.data);
		temp.next = ch.next;
		temp.prev = ch.prev;
		
		ch.prev.next = ct;
		ch.next = ct.next;
		ch.prev = ct.prev;
		ch.next.prev = ct;
				
		ct.prev.next = ch;
		ct.next = temp.next;
		ct.prev = temp.prev;
		ct.next.prev = ch;
		
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

		head.next.next.next.next = new DLLNode(5);
		head.next.next.next.next.prev = head.next.next.next;
		tail = head.next.next.next.next;

		print();
		
		swap(0);
		
		print();
	}

}
