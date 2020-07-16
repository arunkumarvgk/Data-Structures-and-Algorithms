package com.ds.algo.queue;

public class CircularQueueUsingArray {

	static int front, rear, size;
	int arr[];

	public CircularQueueUsingArray(int size) {
		arr = new int[size];
		front = rear = -1;
		size = 0;
	}

	private boolean isFull() {
		return (rear + 1) % arr.length == front;
	}

	private boolean isEmpty() {
		return front == -1;
	}

	private void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}

		if (isEmpty()) {
			front = 0;
		}
		
		rear = (rear + 1) % arr.length; 
		arr[rear] = data;
	}

	private void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		
		int data = arr[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % arr.length;
		}
		System.out.println("Removed element "+data);
	}

	private void print() {
		
		int i = front;
		while (i!=rear) {
			System.out.print(arr[i] + " ");
			i = (i+1) % arr.length;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CircularQueueUsingArray queue = new CircularQueueUsingArray(10);
		
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
