package com.ds.algo.mainproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CrickeBatManufacturer {

	public static void main(String[] args) {
		Set<WeightPrice> batSet = new HashSet<>();
		Set<WeightPrice> cricketerSet = new HashSet<>();
		//Scanner scan = new Scanner(System.in);
		//Integer bats = scan.nextInt();
		//Integer cricketers = scan.nextInt();
		List<WeightPrice> cricketersList = new ArrayList<>();
		List<WeightPrice> batsList = new ArrayList<>();

		/*for (int i = 0; i < cricketers; i++) {
			cricketersList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}
		for (int i = 0; i < bats; i++) {
			batsList.add(new WeightPrice(scan.nextInt(), scan.nextInt()));
		}
		scan.close();*/
		input4(cricketersList, batsList);
		for (WeightPrice cricketer : cricketersList) {
			
			List<WeightPrice> selectedList = new ArrayList<>();
			for (WeightPrice bat :batsList) {
				if(bat.getPrice() <= cricketer.getPrice() && bat.getWeight() > cricketer.getWeight()) {
					selectedList.add(bat);
				}
			
			}
			if (!selectedList.isEmpty()) {
				cricketerSet.add(cricketer);
			}
			batSet.addAll(selectedList);
		}
		Integer finalResult = cricketerSet.size() > batSet.size() ? batSet.size() : cricketerSet.size();
		System.out.println(finalResult);
	}

	private static void input1(List<WeightPrice> cricketers, List<WeightPrice> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new WeightPrice(5, 100));
		cricketers.add(new WeightPrice(7, 80));
		cricketers.add(new WeightPrice(10, 90));
		cricketers.add(new WeightPrice(6, 150));

		bats.add(new WeightPrice(8, 100));
		bats.add(new WeightPrice(10, 90));
		bats.add(new WeightPrice(11, 60));
		bats.add(new WeightPrice(9, 80));
	}

	private static void input2(List<WeightPrice> cricketers, List<WeightPrice> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new WeightPrice(5, 100));
		cricketers.add(new WeightPrice(7, 80));
		cricketers.add(new WeightPrice(10, 90));
		cricketers.add(new WeightPrice(6, 150));

		bats.add(new WeightPrice(8, 100));
		bats.add(new WeightPrice(10, 150));
		bats.add(new WeightPrice(9, 60));
		bats.add(new WeightPrice(7, 80));
	}
	
	private static void input3(List<WeightPrice> cricketers, List<WeightPrice> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new WeightPrice(5, 100));
		cricketers.add(new WeightPrice(5, 90));
		cricketers.add(new WeightPrice(10, 90));
		cricketers.add(new WeightPrice(6, 150));

		bats.add(new WeightPrice(8, 100));
		bats.add(new WeightPrice(10, 150));
		bats.add(new WeightPrice(11, 60));
		bats.add(new WeightPrice(9, 80));
	}
	
	private static void input4(List<WeightPrice> cricketers, List<WeightPrice> bats) {
		cricketers.clear();
		bats.clear();
		cricketers.add(new WeightPrice(5, 500));
		cricketers.add(new WeightPrice(10, 60));
		cricketers.add(new WeightPrice(10, 60));
		cricketers.add(new WeightPrice(10, 60));

		bats.add(new WeightPrice(8, 100));
		bats.add(new WeightPrice(10, 150));
		bats.add(new WeightPrice(11, 60));
		bats.add(new WeightPrice(9, 80));
	}
	
	public static class WeightPrice {
		private Integer weight;
		private Integer price;

		public WeightPrice(Integer weight, Integer price) {
			super();
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
		public String toString() {
			return "WeightPrice [weight=" + weight + ", price=" + price + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((weight == null) ? 0 : weight.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WeightPrice other = (WeightPrice) obj;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			return true;
		}

	}
}
