package com.ds.algo.stack;

class LLStackNode {
	int data;
	LLStackNode next;

	public LLStackNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class StackUsingLL {

	LLStackNode top;

	private void push(int data) {
		LLStackNode newNode = new LLStackNode(data);

		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	private int pop() {
		if (top == null) {
			System.out.println("Empty stack");
			return -1;
		}

		int data = top.data;
		top = top.next;
		return data;
	}

	private int peek() {
		if (top == null) {
			System.out.println("Empty stack");
			return -1;
		}
		return top.data;
	}

	private void print() {
		LLStackNode cur = top;

		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingLL stack = new StackUsingLL();
		System.out.println("Popped "+stack.pop());
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.print();
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		System.out.println("Popped "+stack.pop());
		stack.print();
		System.out.println("Peek "+stack.peek());
		stack.print();
	}

}
