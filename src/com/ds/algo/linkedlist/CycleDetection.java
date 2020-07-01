package com.ds.algo.linkedlist;

public class CycleDetection {

	static SLLNode head;

	private static void findLoop() {

		// Edge conditions

		SLLNode sPtr = head;
		SLLNode fPtr = head;

		while (fPtr != null && fPtr.next != null) {
			fPtr = fPtr.next.next;
			sPtr = sPtr.next;
			if (sPtr == fPtr) {
				break;
			}
		}
		
		if (sPtr == fPtr) {
			System.out.println("Loop Found");
		} else {
			System.out.println("No loop");
		}
	}

	public static void main(String[] args) {
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		//head.next.next.next.next.next = head.next.next;
		findLoop();
	}

}
