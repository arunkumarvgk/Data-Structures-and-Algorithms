package com.ds.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

	int arr[] = new int[26];

	private boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			int remainder = num % i;

			if (remainder == 0) {
				return false;
			}
		}
		return true;
	}

	private void primeNumbers() {
		int index = 0;
		int i = 1;

		while (index != 26) {
			if (isPrime(++i)) {
				arr[index++] = i;
			}
		}
	}

	private int getPrimeProduct(String s) {
		int sPrimeProduct = 1;

		for (int i = 0; i < s.length(); i++) {
			sPrimeProduct *= arr[s.charAt(i) - 'a'];
		}

		return sPrimeProduct;
	}

	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> list = new ArrayList<>();

		if (s.isEmpty() || p.isEmpty()) {
			return list;
		}

		primeNumbers();

		int pPrimeProduct = getPrimeProduct(p);
		int pLength = p.length();

		for (int i = 0; i <= s.length() - pLength; i++) {
			if (pPrimeProduct == getPrimeProduct(s.substring(i, i + pLength))) {
				list.add(i);
			}
		}

		return list;
	}

	public List<Integer> findAnagrams3(String s, String p) {
		List<Integer> list = new ArrayList<>();

		if (s.isEmpty() || p.isEmpty()) {
			return list;
		}

		int charCounts[] = new int[26];

		for (char c : p.toCharArray()) {
			charCounts[c - 'a']++;
		}

		int left = 0;
		int right = 0;
		int count = p.length();

		while (right < s.length()) {
			char rightChar = s.charAt(right++);

			if (charCounts[rightChar - 'a']-- >= 1) {
				count--;
			}

			if (count == 0) {
				list.add(left);
			}

			if (right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
		}

		return list;
	}

	public List<Integer> findAnagramsDocs(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] hash = new int[256]; // character hash

		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash, decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0) {
				list.add(left);
			}
			// if we find the window's size equals to p, then we have to move left (narrow
			// the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if (right - left == p.length()) {

				if (hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;

			}

		}
		return list;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s.trim().isEmpty() || p.trim().isEmpty()) {
			return list;
		}
		int[] hash = new int[26];

		for (char c : p.toCharArray()) {
			hash[c - 'a']++;
		}

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {

			if (hash[s.charAt(right) - 'a'] >= 1) {
				count--;

			}
			hash[s.charAt(right) - 'a']--;
			right++;

			if (count == 0) {
				list.add(left);
			}

			if (right - left == p.length()) {

				if (hash[s.charAt(left) - 'a'] >= 0) {
					count++;

				}
				hash[s.charAt(left) - 'a']++;
				left++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		FindAllAnagramsInString find = new FindAllAnagramsInString();
		List<Integer> list = null;

		list = find.findAnagrams("abab", "ab");

		list.stream().forEach(v -> System.out.print(v + " "));
	}

}
