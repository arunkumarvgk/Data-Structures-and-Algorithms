package com.ds.algo.linkedlist;

public class SLLPrintMiddleNode {

	static SLLNode head;
	
	private static void findMiddle() {
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		
		SLLNode sPtr = head;
		SLLNode fPtr = head;
		
		while (fPtr !=null && fPtr.next != null) {
			fPtr = fPtr.next.next;
			sPtr = sPtr.next;
		}
		
		System.out.println(sPtr.data);
	}
	
	public static void main(String[] args) {
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		head.next.next.next.next.next = new SLLNode(6);
		
		findMiddle();
	}

}
