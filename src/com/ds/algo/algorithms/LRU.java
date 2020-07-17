package com.ds.algo.algorithms;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	char value;
	Node next;
	Node prev;

	public Node(int key, char value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

public class LRU {
	
	Node head;
	Node tail;
	int cacheSize;
	Map<Integer, Node> map;

	public LRU(int cacheSize) {
		this.cacheSize = cacheSize;
		map = new HashMap<>(cacheSize);
		head = null;
		tail = null;
	}

	private void insert(Node node) {
		if (head == null) {
			head = tail = node;
			map.put(node.key, node);
			return;
		}

		/**
		 * If node is already in cache
		 */
		if (map.containsKey(node.key)) {
			// If node is head at head itself no need to rearrange
			if (head.key != node.key) {
				removeNode(node);
				addNode(node);
			}
			return;
		}

		/**
		 * If there is space in cache & node is not in cache
		 */
		if (map.size() < cacheSize && !map.containsKey(node.key)) {
			addNode(node);
		} else {
			removeNode(tail);
			addNode(node);
		}
	}

	private Node getRecentlyUsed() {
		if (map.size() == 0) {
			System.out.println("Empty cache");
			return null;
		}

		Node recentlyUsedNode = head;

		if (map.size() == 1) {
			head = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		map.remove(recentlyUsedNode.key);
		return recentlyUsedNode;
	}

	private Node accessRecentlyUsed() {
		if (map.size() == 0) {
			System.out.println("Empty cache");
			return null;
		}

		return head;
	}

	private void addNode(Node node) {
		map.put(node.key, node);
		node.next = head;
		head.prev = node;
		head = node;
	}

	private void removeNode(Node node) {
		map.remove(node.key);
		if (node == tail) {
			tail = tail.prev;
			tail.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	private void print() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.key + "" + cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRU lru = new LRU(3);
		Node node1 = new Node(1, 'A');
		Node node2 = new Node(2, 'B');
		Node node3 = new Node(3, 'C');
		Node node4 = new Node(4, 'D');
		Node node5 = new Node(5, 'E');

		lru.insert(node1);
		lru.print();
		lru.insert(node1);
		lru.print();
		lru.insert(node2);
		lru.print();
		lru.insert(node3);
		lru.print();
		lru.insert(node4);
		lru.print();
		lru.insert(node1);
		lru.print();
		lru.insert(node2);
		lru.print();
		lru.insert(node5);
		lru.print();
		lru.insert(node1);
		lru.print();
		lru.insert(node2);
		lru.print();
		lru.insert(node3);
		lru.print();
		lru.insert(node4);
		lru.print();
		lru.insert(node5);
		lru.print();

		System.out.println("Access RU " + lru.accessRecentlyUsed().key);
		System.out.println("Get RU " + lru.getRecentlyUsed().key);
		lru.print();
		System.out.println("Get RU " + lru.getRecentlyUsed().key);
		lru.print();
		System.out.println("Get RU " + lru.getRecentlyUsed().key);
		lru.print();
		lru.getRecentlyUsed();
	}

}
