package com.ds.algo.linkedlist;

public class QueueUsingCLL {
	
	static SLLNode front;
	static SLLNode rear;
	
	private static void enqueue(int data) {
		SLLNode node = new SLLNode(data);
		if (front == null) {
			node.next = node;
			front = node;
			rear = node;
			return;
		}
		node.next = rear.next;
		rear.next = node;
		rear = node;
	}
	
	
	private static void deueue() {
		if (front == null) {
			System.out.println("Empty");
			return;
		}
		
		if (front == rear) {
			front = rear = null;
			return;
		}
		
		front = front.next;
		rear.next = front;
	}
	
	private static void print() {
		SLLNode cur = front;
		
		do {
			System.out.print(cur.data+" ");
			cur = cur.next;
		} while (cur != front);
		
		System.out.println();
	}
	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		print();
		deueue();
		print();
		enqueue(4);
		enqueue(5);
		enqueue(1);
		print();
		deueue();
		print();
		enqueue(2);
		print();
	}

}
