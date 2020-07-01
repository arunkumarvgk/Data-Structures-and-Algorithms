package com.ds.algo.linkedlist;

public class SLLFindLength {

	static SLLNode head;
	
	private static void findLength() {
		int length = 0;
		SLLNode cur = head;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		
		System.out.println(length);
	}
	
	private static int getLength(SLLNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + getLength(node.next);
	}
	
	public static void main(String[] args) {
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		findLength();
		System.out.println(getLength(head));
	}

}
