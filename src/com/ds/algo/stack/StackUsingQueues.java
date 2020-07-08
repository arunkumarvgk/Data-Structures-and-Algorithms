package com.ds.algo.stack;

import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingQueues {

	Queue<Integer> queue1 = new PriorityQueue<>();
	Queue<Integer> queue2 = new PriorityQueue<>();

	private void push(int data) {
		queue1.add(data);
	}

	private int pop() {
		if (queue1.isEmpty() && queue2.isEmpty()) {
			System.out.println("Empty Stack");
			return -1;
		}

		if (queue2.isEmpty()) {
			while (queue1.size() != 1) {
				queue2.add(queue1.poll());
			}

			return queue1.poll();
		} else {
			while (queue2.size() != 1) {
				queue1.add(queue2.poll());
			}

			return queue2.poll();
		}
	}

	private void print() {
		if (queue1.isEmpty()) {
			queue2.forEach(elem -> System.out.print(" " + elem));
		} else {
			queue1.forEach(elem -> System.out.print(" " + elem));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingQueues stack = new StackUsingQueues();
		System.out.println(" Removed "+ stack.pop());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(" Removed "+ stack.pop());
		stack.print();
		System.out.println(" Removed "+ stack.pop());
		System.out.println(" Removed "+ stack.pop());
		System.out.println(" Removed "+ stack.pop());
		stack.print();
	}

}
