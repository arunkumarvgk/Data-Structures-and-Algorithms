package com.ds.algo.mainproblems;

public class GasStationProblem {

	private static int findStartingPoint(int petrol[], int distance[]) {
		int surplus = 0;
		int deficit = 0;
		int startFrom = 0;

		for (int i = 0; i < petrol.length; i++) {
			// Previous Leftover petrol + current petrol - distance to be travelled
			surplus = surplus + (petrol[i] - distance[i]);

			// if surplus is less than 0 that means you can't go to the next petrol station
			// So we change the starting point and surplus to deficit
			if (surplus < 0) {
				startFrom = i + 1;
				deficit = deficit + surplus;
				surplus = 0;
			}
		}

		if (surplus + deficit >= 0) {
			return startFrom + 1;
		} else {
			return -1;
		}
	}

	public static int findStartingPoint2(int petrol[], int distance[]) {
		int sumRemaining = 0;
		int total = 0;
		int start = 0;

		for (int i = 0; i < petrol.length; i++) {
			int remaining = petrol[i] - distance[i];

			if (sumRemaining >= 0) {
				sumRemaining += remaining;
			} else {
				sumRemaining = remaining;
				start = i;
			}
			total += remaining;
		}

		if (total >= 0) {
			return start;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(findStartingPoint(
				new int[] { 959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481,
						337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7,
						209 },
				new int[] { 862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887,
						571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517,
						237, 884 }));

		System.out.println(findStartingPoint(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));

		System.out.println(findStartingPoint(
				new int[] { 39, 959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953,
						481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718,
						738, 7, 209 },
				new int[] { 39, 862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887,
						571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517,
						237, 884 }));
	}
}
