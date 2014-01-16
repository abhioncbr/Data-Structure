package com.backtrack.problem.permutation;

import edu.princeton.cs.algs4.Stopwatch;

public class StringPermutation {
	
	/**
	 * Swap characters.
	 *
	 * @param str the str
	 * @param arrayIndex1 the array index1
	 * @param arrayIndex2 the array index2
	 * @return the string
	 */
	private String swapCharacters(char[] str, int arrayIndex1, int arrayIndex2){
		char temp = str[arrayIndex1];
		str[arrayIndex1] = str[arrayIndex2];
		str[arrayIndex2] = temp;
		return new String(str);
	}
	
	/**
	 * Permutation.
	 *
	 * @param str the str
	 * @param startingIndex the starting index
	 * @param endingIndex the ending index
	 */
	private void permutation(String str, int startingIndex, int endingIndex){
		int j;
		if (startingIndex == endingIndex){
			System.out.println(str);
		}else {
			for (j = startingIndex; j <= endingIndex; j++) {
				str = swapCharacters(str.toCharArray() , startingIndex, j);
				permutation(str, startingIndex + 1, endingIndex);
				str = swapCharacters(str.toCharArray() , startingIndex, j); // backtrack
			}
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		String str = "ABCDEF";
		StringPermutation permutation = new StringPermutation();
		
		Stopwatch watch = new Stopwatch();
		permutation.permutation(str, 0, str.length()-1);
		System.out.println("Elapsed Time            = " + watch.elapsedTime());
	}

}
