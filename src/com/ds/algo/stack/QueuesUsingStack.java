package com.ds.algo.stack;

import java.util.Stack;

public class QueuesUsingStack {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	private void enQueue(int data) {
		stack1.add(data);
	}

	private int deQueue() {
		while (!stack1.empty()) {
			stack2.add(stack1.pop());
		}

		int data = stack2.pop();

		while (!stack2.empty()) {
			stack1.add(stack2.pop());
		}
		return data;
	}

	private void print() {
		while (!stack1.empty()) {
			stack2.add(stack1.peek());
			System.out.print(stack1.pop()+" ");
		}
		System.out.println();
		
		while (!stack2.empty()) {
			stack1.add(stack2.pop());
		}
	}

	public static void main(String[] args) {
		QueuesUsingStack queue = new QueuesUsingStack();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.print();
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		queue.print();
	}

}
