package com.ds.algo.linkedlist;

public class SLLInsertion {
	
	SLLNode head;
	
	private void insertFront(int data) {
		if (head == null) {
			head = new SLLNode(data);
			return;
		}
		
		SLLNode node = new SLLNode(data);
		node.next = head;
		head = node;
	}
	
	private void insertAfterGivenNode(int existingData, int data) {
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		SLLNode node = new SLLNode(data);
		SLLNode cur = head;
		
		while (cur.next !=null && cur.data != existingData) {
			cur = cur.next;
		}
		
		if (cur.data == existingData) {
			node.next = cur.next;
			cur.next = node;
		} else {
			System.out.println("Data not found");
		}
	}
	
	private void insertEnd(int data) {
		if (head == null) {
			head = new SLLNode(data);
			return;
		}
		
		SLLNode node = new SLLNode(data);
		SLLNode cur = head;
		
		while (cur.next !=null) {
			cur = cur.next;
		}
		
		cur.next = node;
	}
	
	private void print() {
		SLLNode node = head;
		
		while (node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		SLLInsertion in = new SLLInsertion();
		
		in.insertEnd(1);
		in.insertAfterGivenNode(1, 2);
		in.insertEnd(3);
		in.insertFront(0);
		in.insertEnd(5);
		in.insertAfterGivenNode(3, 4);
		
		in.print();
	}

}
