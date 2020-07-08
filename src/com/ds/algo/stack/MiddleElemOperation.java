package com.ds.algo.stack;

class Node {
	int data;
	Node next;
	Node prev;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class MiddleElemOperation {

	static Node head;
	static int size;
	static Node mid;
	
	private static void push(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = mid = n;
			size++;
			return;
		}

		head.next = n;
		n.prev = head;
		size++;
		
		if (size%2 !=0 ) {
			mid = mid.next;
		}
		head = n;
	}
	
	private static void pop() {
		if (head == null) {
			System.out.println("No Pop");
			return;
		}
		
		System.out.println("Removing "+head.data);
		head =  head.prev;
		if (size%2 !=0 ) {
			mid = mid.prev;
		}
		size--;
	}
	
	private static void findMiddle() {
		if (mid == null) {
			System.out.println("No Middle");
			return;
		}
		
		System.out.println("Middle "+mid.data);
	}
	
	private static void deleteMiddle() {
		if (head == null) {
			System.out.println("No Delete");
			return;
		}
		
		System.out.println("Deleting "+mid.data);
		if (size == 1) {
			head = mid = null;
			size =0;
			return;
		}
		
		
		if (size == 2) {
			mid = head;
			head.prev = null;
			size--;
			return;
		}
		
		
		Node temp = null;
		if (size%2 != 0) {
			temp = mid.prev;
		} else {
			temp = mid.next;
		}
		
		mid.prev.next = mid.next;
		mid.next.prev = mid.prev;
		size--;
		mid = temp;
	}
	private static  void print() {
		Node cur = head;
		System.out.print("Values :::: ");
		while (cur !=null) {
			System.out.print(cur.data+" ");
			cur = cur.prev;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		findMiddle();
		
		push(1);
		
		print();
		findMiddle();
		
		push(2);
		print();
		findMiddle();
		
		push(3);
		print();
		findMiddle();
		
		push(4);
		print();
		findMiddle();
		
		push(5);
		print();
		findMiddle();
		
		print();
		pop();
		print();
		findMiddle();
		
		push(5);
		print();
		findMiddle();
		
		push(6);
		print();
		findMiddle();
		
		push(7);
		print();
		findMiddle();
		
		print();
		pop();
		findMiddle();
		print();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		print();
		deleteMiddle();
		print();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		deleteMiddle();
		print();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		deleteMiddle();
		print();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		deleteMiddle();
		print();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		deleteMiddle();
		print();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		deleteMiddle();
		print();
	}

}
