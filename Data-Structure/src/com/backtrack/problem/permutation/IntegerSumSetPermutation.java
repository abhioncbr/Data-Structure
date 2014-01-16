package com.backtrack.problem.permutation;

public class IntegerSumSetPermutation {
	

	/**
	 * Swap integers.
	 *
	 * @param set the set
	 * @param arrayIndex1 the array index1
	 * @param arrayIndex2 the array index2
	 * @return the integer[]
	 */
	private Integer[] swapIntegers(Integer[] set, int arrayIndex1, int arrayIndex2){
		Integer temp = set[arrayIndex1];
		set[arrayIndex1] = set[arrayIndex2];
		set[arrayIndex2] = temp;
		return set;
	}
	

	/**
	 * Permutation.
	 *
	 * @param set the set
	 * @param startingIndex the starting index
	 * @param endingIndex the ending index
	 */
	private void permutation(Integer[] set, int startingIndex, int endingIndex){
		int j;
		if (startingIndex == endingIndex){
			
		}else {
			for (j = startingIndex; j <= endingIndex; j++) {
				set = swapIntegers(set , startingIndex, j);
				permutation(set, startingIndex + 1, endingIndex);
				set = swapIntegers(set , startingIndex, j); // backtrack
			}
		}
	}
	
	private void printIntegerSet(Integer[] set){
		for(int i=0;i<set.length;i++){
			System.out.print(set[i]);
		}
	}

}
