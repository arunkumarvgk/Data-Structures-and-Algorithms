package com.ds.algo.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUsingArray {

	int arr[];
	static int front;
	static int rear;
	static int size;

	public QueueUsingArray(int size) {
		this.arr = new int[size];
		front = -1;
		rear = -1;
	}

	private boolean isEmpty() {
		return front == -1;
	}

	private boolean isFull() {
		return rear == arr.length - 1;
	}

	private void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue overflow");
			return;
		}

		if (isEmpty()) {
			front = 0;
		}
		size++;
		arr[++rear] = data;
	}

	private void dequeue() {
		if (front > rear) {
			System.out.println("No items");
			return;
		}
		if (isEmpty()) {
			System.out.println("Empty Queue");
			return;
		}
		
		size--;
		System.out.println("Element removed " + arr[front++]);
	}

	private void print() {
		for (int i = front; i < rear; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(10);
		
		queue.dequeue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.print();
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.print();
		queue.enqueue(12);
	}
}
