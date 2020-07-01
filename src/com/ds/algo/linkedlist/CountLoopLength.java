package com.ds.algo.linkedlist;

public class CountLoopLength {
	static SLLNode head;

	private static void findLength() {
		//EdgeConditions
		
		SLLNode sPtr = head;
		SLLNode fPtr = head;
		int length = 0;
		
		while (fPtr != null && fPtr.next != null) {
			sPtr = sPtr.next;
			fPtr = fPtr.next.next;
			
			if (sPtr == fPtr) {
				sPtr = sPtr.next;
				length++;
				while (sPtr != fPtr) {
					sPtr = sPtr.next;
					length++;
				}
				break;
			}
		}
		
		if (sPtr == fPtr) {
			System.out.println("Loop Found and length is "+length);
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
		head.next.next.next.next.next = head.next;
		findLength();
	}

}
