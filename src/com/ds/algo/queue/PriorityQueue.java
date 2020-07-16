package com.ds.algo.queue;

class PNode {
	int priority;
	char value;

	public PNode(int priority, char value) {
		this.priority = priority;
		this.value = value;
	}
}

public class PriorityQueue {

	private static final int MAX = 10;
	private static int heapSize;
	PNode nodes[] = new PNode[MAX];

	/**
	 * Follow bottom up, insert value to last index and check with parent go till
	 * root if required.
	 */
	private void insert(PNode node) {
		if (heapSize == MAX) {
			System.out.println("Queue is full");
			return;
		}

		if (heapSize == 0) {
			nodes[heapSize++] = node;
			return;
		}

		int childIndex = heapSize;
		nodes[heapSize++] = node;

		int parentIndex = (childIndex - 1) / 2;

		while (parentIndex >= 0 && nodes[parentIndex].priority < nodes[childIndex].priority) {
			swap(parentIndex, childIndex);
			childIndex = parentIndex;
			parentIndex = (childIndex - 1) / 2;
		}
	}

	private void swap(int parentIndex, int childIndex) {
		PNode temp = nodes[parentIndex];
		nodes[parentIndex] = nodes[childIndex];
		nodes[childIndex] = temp;
	}

	private void print() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(nodes[i].priority + " ");// : " + nodes[i].value + " , ");
		}
		System.out.println();
	}

	private void peek() {
		System.out.println("Max  " + nodes[0].priority + ":" + nodes[0].value);
	}

	private void poll() {
		PNode node = nodes[0];
		nodes[0] = nodes[heapSize - 1];
		heapSize--;
		heapify(0, heapSize);
		System.out.println("Polled " + node.priority + " : " + node.value);
	}

	private void heapify(int index, int n) {
		int left = (index * 2) + 1;
		int right = (index * 2) + 2;

		int largest = index;

		if (left < n && nodes[left].priority > nodes[largest].priority) {
			largest = left;
		}

		if (right < n && nodes[right].priority > nodes[largest].priority) {
			largest = right;
		}

		if (largest != index) {
			swap(largest, index);
			heapify(largest, n);
		}
	}

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.insert(new PNode(3, 'B'));
		queue.print();

		queue.insert(new PNode(1, 'A'));
		queue.print();
		queue.peek();

		queue.insert(new PNode(4, 'J'));
		queue.print();

		queue.insert(new PNode(8, 'D'));
		queue.print();
		queue.peek();

		queue.insert(new PNode(21, 'K'));
		queue.print();
		queue.peek();

		queue.poll();
		queue.peek();
		queue.print();

		queue.poll();
		queue.print();
		queue.peek();
	}

}
