package com.ds.algo.linkedlist;

import java.security.Principal;

public class DetectStartOfLoop {

	static SLLNode head;
	
	private static void findStart() {
		//Edge Cases
		
		SLLNode sPtr = head;
		SLLNode fPtr = head;
		SLLNode temp = head;

		while (fPtr != null && fPtr.next != null) {
			fPtr = fPtr.next.next;
			sPtr = sPtr.next;
			if (sPtr == fPtr) {
				while (sPtr != temp) {
					sPtr = sPtr.next;
					temp= temp.next;
				}
				break;
			}
		}
		
		System.out.println(sPtr.data);
	}
	
	private static void breakLoop() {
		//Edge Cases
		
		SLLNode sPtr = head;
		SLLNode fPtr = head;
		SLLNode temp = head;

		while (fPtr != null && fPtr.next != null) {
			fPtr = fPtr.next.next;
			sPtr = sPtr.next;
			if (sPtr == fPtr) {
				while (sPtr.next != temp.next) {
					sPtr = sPtr.next;
					temp= temp.next;
				}
				
				sPtr.next = null;
				break;
			}
		}
		
		System.out.println(sPtr.data);
	}
	
	private static void print() {
		SLLNode node = head;
		while (node != null) {
			System.out.print(node.data+" ");
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
		head.next.next.next.next.next.next.next.next.next = head.next.next;
		
		findStart();
		breakLoop();
		print();
	}

}
