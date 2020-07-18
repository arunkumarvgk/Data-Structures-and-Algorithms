package com.ds.algo.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class OddAndEvenLL {

	private static void connect(ListNode node) {
		if (node == null || node.next == null) {
			return						;
		}
		
		ListNode odd = node;
		ListNode even = node.next;
		ListNode evenS = node.next;
		
		while (even != null && even.next != null) {
			
			if (odd.next != null && odd.next.next != null) {
				odd.next = odd.next.next;
				odd = odd.next;
			}
			
			if (even.next != null) {
				even.next = even.next.next;;
				even = even.next;
			}
		}
		
		odd.next = evenS;
	}

	private static void print(ListNode head) {
		ListNode cur = head;
		
		while (cur != null) {
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1, 
				new ListNode(2, 
						new ListNode(3, 
								new ListNode(4, 
										new ListNode(5, 
												new ListNode(6, 
														new ListNode(7, 
																new ListNode(8, null))))))));
		print(head);
		connect(head);
		print(head);

	}

}
