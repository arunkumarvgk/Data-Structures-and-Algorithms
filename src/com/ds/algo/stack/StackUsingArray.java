package com.ds.algo.stack;

public class StackUsingArray {

	private int arr[];
	private int top;
	private int size;

	public StackUsingArray(int size) {
		this.size = size;
		this.top = -1;
		this.arr = new int[size];
	}

	private void push(int data) {
		if (top >= size-1) {
			System.out.println("Stack is full");
			return;
		}

		arr[++top] = data;
	}

	private int pop() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return -1;
		}

		return arr[top--];
	}
	
	private int peek() {
		if (top == -1) {
			System.out.println("Stack is empty");
			return -1;
		}

		return arr[top];
	}
	
	private void print() {
		int cur = top;

		while (cur != -1) {
			System.out.print(arr[cur--] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray(10);
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
