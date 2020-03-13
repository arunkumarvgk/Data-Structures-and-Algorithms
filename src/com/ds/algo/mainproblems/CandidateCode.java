package com.ds.algo.mainproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CandidateCode {
	private static int result = 0;

	public static void main(String[] args) throws Exception {
		/*
		 * Scanner scan = new Scanner(System.in); String firstLine = scan.nextLine();
		 * Integer cricketers = Integer.parseInt(firstLine.split(" ")[0]); Integer bats
		 * = Integer.parseInt(firstLine.split(" ")[1]); List<WeightPrice> batsList = new
		 * ArrayList<>(); List<WeightPrice> cricketersList = new ArrayList<>(); for (int
		 * i = 0; i < cricketers; i++) { String cricketerReq = scan.nextLine();
		 * cricketersList.add(new
		 * WeightPrice(Integer.parseInt(cricketerReq.split(" ")[0]),
		 * Integer.parseInt(cricketerReq.split(" ")[1]))); }
		 * 
		 * for (int i = 0; i < bats; i++) { String batReq = scan.nextLine();
		 * batsList.add( new WeightPrice(Integer.parseInt(batReq.split(" ")[0]),
		 * Integer.parseInt(batReq.split(" ")[1]))); } scan.close();
		 * List<List<WeightPrice>> finalList = getSelectedBats(batsList,
		 * cricketersList); //findMaxCombination(finalList, finalList.get(0), 0, new
		 * ArrayList<WeightPrice>(), 0, batsList.size());
		 */
		hello();
		System.out.println(result);
	}

	private static void hello() {
		List<List<String>> finalList = new ArrayList<>();
		List<String> list1 = new ArrayList<>(); // 0 1 2 2 , 0 3 2 0 , 2 2 2 2 2 0 2 3 2 2 3 0
		list1.add("0");
		list1.add("2");

		List<String> list2 = new ArrayList<>();
		list2.add("2");
		list2.add("1");
		

		List<String> list3 = new ArrayList<>();
		list3.add("3");
		list3.add("2");

		List<String> list4 = new ArrayList<>();
		list4.add("1");
		list4.add("0");
		

		finalList.add(list1);
		finalList.add(list2);
		finalList.add(list3);
		finalList.add(list4);
		
		
		findMaxCombination(finalList, finalList.get(0), 0, new ArrayList<String>(), 0, 100);
		
		/*finalList.clear();
		list1.clear();
		list2.clear();
		list3.clear();
		list4.clear();
		
		list1.add(e)*/

	}

	private static void findMaxCombination(List<List<String>> finalList, List<String> list, int count,
			List<String> listTobeRemoved, int finalCount, int batSize) {
		System.out.println("Hello ");
		List<String> temp = new ArrayList<>();
		copyElem(temp, list);
		list.removeAll(listTobeRemoved);

		if (count == finalList.size() - 1) {
			
			if (list.isEmpty()) {
				if (result < finalCount) {
					result = finalCount;
				}
			} else {
				if (result < finalCount + 1) {
					result = finalCount + 1;
				}
			}
			if (result == batSize) {
				System.out.println(result);
				System.exit(0);
			}
			copyElem(list, temp);
			return;
		}
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				listTobeRemoved.add(list.get(i));
				findMaxCombination(finalList, finalList.get(count + 1), count + 1, listTobeRemoved, finalCount + 1,batSize);
				copyElem(list, temp);
				listTobeRemoved.remove(list.get(i));
			}
		} else {
			findMaxCombination(finalList, finalList.get(count + 1), count + 1, listTobeRemoved, finalCount, batSize);
			copyElem(list, temp);
		}
	}

	private static void copyElem(List<String> temp, List<String> list) {
		list.stream().forEach(val -> {
			if (!temp.contains(val)) {
				temp.add(val);
			}
		});
		
	}

	private static List<List<WeightPrice>> getSelectedBats(List<WeightPrice> batsList,
			List<WeightPrice> cricketersList) {
		List<List<WeightPrice>> finalList = new ArrayList<>();
		for (WeightPrice cricketer : cricketersList) {
			List<WeightPrice> selectedList = new ArrayList<>();
			for (WeightPrice bat : batsList) {
				if (bat.getPrice() <= cricketer.getPrice() && bat.getWeight() > cricketer.getWeight()) {
					selectedList.add(bat);
				}
			}
			if (!selectedList.isEmpty()) {
				finalList.add(selectedList);
			}
		}
		return finalList;
	}

	public static class WeightPrice {
		private Integer weight;
		private Integer price;

		public WeightPrice(Integer weight, Integer price) {
			this.weight = weight;
			this.price = price;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			return this == obj;
		}

	}
}