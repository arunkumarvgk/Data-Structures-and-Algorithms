package com.ds.algo.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	private boolean isPrime(int num) {
		for (int i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		int primeNumbers[] = new int[26];
		int j = 0;

		for (int i = 2; j < 26; i++) {
			if (isPrime(i)) {
				primeNumbers[j++] = i;
			}
		}

		Map<Integer, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			int product = 1;
			List<String> list;

			for (int l = 0; l < s.length(); l++) {
				int index = (int) s.charAt(l) - 'a';
				product = product * primeNumbers[index];
			}

			if (map.containsKey(product)) {
				list = map.get(product);
			} else {
				list = new ArrayList<>();
			}
			list.add(s);
			map.put(product, list);
		}

		for (List<String> v : map.values()) {
			result.add(v);
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<String>> list = new Anagrams().groupAnagrams(new String[] {"eat","bat"});
		list.forEach(v -> {
			v.forEach(vv-> {
				System.out.print(vv+" ");
			});
			System.out.println();
		});
	}

}
