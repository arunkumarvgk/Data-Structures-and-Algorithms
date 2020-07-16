package com.ds.algo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfWithSecondHalf {

	private static void interleave(Queue<Integer> queue) {
		int size = queue.size() /2;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < size; i++) {
			stack.push(queue.remove());
		}
		
		while( ! stack.empty()) {
			queue.add(stack.pop());
		}
		
		for (int i = 0; i < size; i++) {
			queue.add(queue.remove());
		}
		
		for (int i = 0; i < size; i++) {
			stack.push(queue.remove());
		}
		
		for (int i = 0; i < size; i++) {
			queue.add(stack.pop());
			queue.add(queue.remove());
		}
		
		queue.stream().forEach(v -> System.out.print(v+" "));
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		queue.add(19);
		queue.add(20);
		interleave(queue);
	}

}
