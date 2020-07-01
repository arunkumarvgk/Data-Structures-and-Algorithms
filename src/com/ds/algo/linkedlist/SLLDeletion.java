package com.ds.algo.linkedlist;

public class SLLDeletion {
	
	static SLLNode head;
	
	private void deleteNodeOfGivenKey(int data) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		//if delete node is first node
		if (head.data == data) {
			head = head.next;
			return;
		}
		
		SLLNode cur = head;
		SLLNode prev = null;
		
		while ( cur != null && cur.data != data) {
			prev = cur;
			cur = cur.next;
		}
		
		if (cur == null) {
			System.out.println("Data Not found");
		} else {
			prev.next = cur.next;
		}
	}
	
	private void deleteBasedOnPosition(int pos) {
		pos = pos -1;
		if (pos < 0) {
			System.out.println("Invalid Position");
			return;
		}
		
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		if (pos == 0) {
			head = head.next;
			return;
		}
		
		SLLNode cur = head;
		SLLNode prev = null;
		while (pos > 0 && cur != null) {
			prev = cur;
			cur = cur.next;
			pos--;
		}
		
		if (cur == null) {
			System.out.println("Position not found");
		} else {
			prev.next = cur.next;
		}
	}
	
	private void print() {
		SLLNode node = head;
		while (node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SLLDeletion d = new SLLDeletion();
		
		d.deleteNodeOfGivenKey(7);
		
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		d.print();
		d.deleteNodeOfGivenKey(7);
		
		d.deleteNodeOfGivenKey(1);
		d.print();
		
		d.deleteNodeOfGivenKey(3);
		d.print();
		
		d.deleteNodeOfGivenKey(5);
		d.print();
		
		d.deleteNodeOfGivenKey(4);
		d.print();
		
		d.deleteNodeOfGivenKey(5);
		d.print();
		
		d.deleteNodeOfGivenKey(2);
		d.print();
		
		d.deleteNodeOfGivenKey(1);
		d.print();
		
		System.out.println("=============================================================");
		
		
		head = new SLLNode(1);
		head.next = new SLLNode(2);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(4);
		head.next.next.next.next = new SLLNode(5);
		d.print();
		
		d.deleteBasedOnPosition(-1);
		d.deleteBasedOnPosition(5);
		d.print();
		d.deleteBasedOnPosition(1);
		d.print();
		
		d.deleteBasedOnPosition(2);
		d.print();
	}

}
