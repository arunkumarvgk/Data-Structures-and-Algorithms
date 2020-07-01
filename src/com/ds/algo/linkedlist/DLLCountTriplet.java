package com.ds.algo.linkedlist;

public class DLLCountTriplet {

	static DLLNode head;
	static DLLNode tail;
	
	private static void count(int x) {
		DLLNode cur;
		DLLNode first;
		DLLNode last;
		
		cur = head;
		
		int count = 0;
		while (true) {
			
			first = cur.next;
			last =  tail;
			
			if (cur.data +first.data+ first.next.data > x) {
				break;
			}
			
			if (first.next == last) {
				if(cur.data + first.data + last.data == x) {
					count++;
					System.out.println(cur.data+" "+first.data+" "+last.data);
					break;
				}
			}
			while (first.data < last.data) {
				int temp = cur.data + first.data + last.data;
				
				if(temp == x) {
					count++;
					System.out.println(cur.data+" "+first.data+" "+last.data);
					first = first.next;
					last = last.prev;
				} else if (temp < x) {
					first = first.next;
				} else {
					last = last.prev;
				}
			}
			cur = cur.next;
		}
		
		System.out.println("Total "+count);
	}
	
	public static void main(String[] args) {
		DLLNode node1 = new DLLNode(1);
		DLLNode node2 = new DLLNode(2);
		//DLLNode node3 = new DLLNode(3);
		DLLNode node4 = new DLLNode(4);
		DLLNode node5 = new DLLNode(5);
		DLLNode node6 = new DLLNode(6);
		//DLLNode node7 = new DLLNode(7);
		DLLNode node8 = new DLLNode(8);
		DLLNode node9 = new DLLNode(9);
		//DLLNode node10 = new DLLNode(10);
		
		node1.prev = null;
		node1.next = node2;
		
		node2.prev = node1;
		node2.next = node4;

		//node3.prev = node2;
		//node3.next = node4;
		
		node4.prev = node2;
		node4.next = node5;
		
		node5.prev = node4;
		node5.next = node6;
		
		node6.prev = node5;
		node6.next = node8;
		
		//node7.prev = node6;
		//node7.next = node8;
		
		node8.prev = node6;
		node8.next = node9;
		
		node9.prev = node8;
		node9.next = null;
		
		//node10.prev = node9;
		//node10.next = null;
		
		head = node1;
		tail = node9;
		count(15);
	}

}
