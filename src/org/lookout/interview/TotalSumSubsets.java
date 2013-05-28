package org.lookout.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds all subsets of an array where the largest number is the sum of the remaining numbers
 * @author Srimanth
 *
 */
public class TotalSumSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] numbers = new int[]{1, 1, 2, 3};
		int[] numbers = new int[] { 3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99};
		int result = findSubsetCount(numbers);
		System.out.println(result);
	}

	/**
	 * Assumes that the given array is sorted in ascending order and the elements are distinct.
	 * @param numbers Set of numbers
	 * @return number of subsets that satsify the requirements.
	 */
	public static int findSubsetCount(int[] numbers) {
		// <K, V> : <Number, number of ways to sum>
		Map<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
		countsMap.put(0, 1); // base

		int totalSubsetCount = 0;

		// iterate given numbers
		for (int number : numbers) {
			if (countsMap.containsKey(number)) {
				// There's already an entry for no. of ways to sum
				totalSubsetCount = totalSubsetCount + countsMap.get(number);
			}
			// Update other counts.
			updateCounts(number, countsMap, numbers[numbers.length - 1]);

		}
		return totalSubsetCount;
	}

	/**
	 * Adds number to all the existing keys in countsMap: <Sum, no. of ways> and updates the entry: <Sum + number, no. of ways>
	 * @param number Number
	 * @param countsMap <Sum, no. of ways so far>
	 * @param max Maximum sum to consider.
	 */
	private static void updateCounts(int number, Map<Integer, Integer> countsMap, int max) {
		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
		temp.putAll(countsMap);
		int currentSum = 0;
		for (Integer key : temp.keySet()) {
			currentSum = number + key;
			// We do care only up to the max sum which is last number in numbers[]
			if (currentSum <= max) {
				if (countsMap.containsKey(currentSum)) {
					// If present, increment the count by "new ways of getting the sum = currentSum"
					countsMap.put(currentSum, countsMap.get(currentSum) + temp.get(key));
				} else {
					countsMap.put(currentSum, temp.get(key));
				}
			}
		}
	}

}

