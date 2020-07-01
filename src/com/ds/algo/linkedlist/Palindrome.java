package com.ds.algo.linkedlist;

public class Palindrome {
	
	static SLLNode head;
	static SLLNode secondHalf;
	private static void find() {
		//Edge Cases
		
		SLLNode fPtr =  head;
		SLLNode sPtr = head;
		SLLNode sPrevPtr = null;
		SLLNode midPtr = null;
		while (fPtr != null && fPtr.next != null) {
			fPtr = fPtr.next.next;
			sPrevPtr = sPtr;
			sPtr = sPtr.next;
		}
		
		if (fPtr != null) {
			midPtr = sPtr;
			sPtr = sPtr.next;
		}
		
		//sPtr = sPtr.next;
		sPrevPtr.next = null;
		secondHalf = sPtr;
		
		reverse();
		if (compare()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		reverse();
		
		if (midPtr !=null ) {
			sPrevPtr.next = midPtr;
			midPtr.next = secondHalf;
		} else {
			sPrevPtr.next = secondHalf;
		}
	}
	
	private static boolean compare() {
		SLLNode firstHalf =  head;
		while (firstHalf !=null && secondHalf != null) {
			if (firstHalf.data == secondHalf.data) {
				firstHalf = firstHalf.next;
				secondHalf = secondHalf.next;
			} else {
				return false;
			}
		}
		
		if (firstHalf == null && secondHalf == null) {
			return true;
		}
		
		return false;
	}

	private static void reverse() {
		SLLNode prev = null;
		SLLNode cur = secondHalf;
		SLLNode next = null;
		
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		secondHalf = prev;
	}

	public static void main(String[] args) {
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(3);
		head.next.next.next.next = new SLLNode(2);
		head.next.next.next.next.next = new SLLNode(1);
		find();

	}

}
