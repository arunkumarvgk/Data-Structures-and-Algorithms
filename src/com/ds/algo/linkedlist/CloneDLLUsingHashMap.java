package com.ds.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneDLLUsingHashMap {

	static DLLNode head;
	static DLLNode clonedHead;
	static DLLNode clonedHead2;

	private static void print(DLLNode start) {
		DLLNode cur = start;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	private static void cloneLL() {
		Map<DLLNode, DLLNode> map = new HashMap<>();
		
		DLLNode cur = head;
		
		while (cur != null) {
			map.put(cur, new DLLNode(cur.data));
			cur = cur.next;
		}
		
		cur = head;
		
		while (cur != null) {
			DLLNode temp = map.get(cur);
			temp.next = map.get(cur.next);
			temp.prev = map.get(cur.prev);
			cur = cur.next;
		}
		
		clonedHead = map.get(head);
	}
	
	private static void cloneLL2() {
		Map<DLLNode, DLLNode> map = new HashMap<>();
		
		DLLNode cur = head;
		DLLNode prev = null;
		
		while (cur != null) {
			map.put(cur, cur.next);
			cur = cur.next;
		}
		
		cur = head;
		
		clonedHead2 =  new DLLNode(cur.data);
		
		DLLNode copyCur = clonedHead2;
		DLLNode copyPrev = null;
		
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
			prev.next = copyCur;
			copyPrev = copyCur;
			copyCur = new DLLNode(cur.data);
			copyPrev.next = copyCur;
			copyPrev.prev = prev;
		}
		
		cur.next = copyCur;
		copyCur.prev = cur;
		
		copyCur = clonedHead2;
		
		while (copyCur != null) {
			copyCur.prev = copyCur.prev.prev.next;
			copyCur = copyCur.next;
		}
		
		cur = head;
		while (cur != null) {
			cur.next = map.get(cur);
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		head = new DLLNode(1);
		head.next = new DLLNode(2);
		head.next.next = new DLLNode(3);
		head.next.next.next = new DLLNode(4);
		
		head.prev = head.next.next.next;
		head.next.prev = head.next.next;
		head.next.next.prev = head;
		head.next.next.next.prev = head.next.next;
		
		print(head);
		
		cloneLL();
		
		print(clonedHead);
		
		cloneLL2();
		
		print(clonedHead2);
		
	}

}
