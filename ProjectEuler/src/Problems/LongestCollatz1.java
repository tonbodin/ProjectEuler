/*
 * Problem #13: Longest Collatz Sequence
 * 
 * The following sequence is defined for the set of positive integers
 * 		n -> n/2 (n is even)
 * 		n -> 3*n + 1 (n is odd)
 * 
 * For example, for 13: 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * Which starting number, under 1 million, produces the Longest Collatz sequence?
 */

package Problems;

import java.util.ArrayList;

public class LongestCollatz1 {
	
	private static final int RANGE = 1000000;

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		//Create an array of length RANGE.
		//Each index 'i' will contain the size of 
		//the collatz sequence if 'i' were the starting number
		int[] arr = new int[RANGE];
		
		int max = Integer.MIN_VALUE;
		
		//Keeps track of the starting number
		//arbitrarily set to 1
		int num = 1;
		
		for(int i = RANGE - 1 ; i >= 1; i--) {
			int val = function(i, arr);
			if(val > max) {
				max = val;
				num = i;
			}
		}
		
		long endTime = System.nanoTime();
		
		//OUTPUT: Number: 837799 Times: 524 Duration: 0.137300979 sec
		System.out.println("Number: " + num + " Times: " + max + " Duration: " + (endTime - startTime)/Math.pow(10, 9) + " sec");

	}

	@SuppressWarnings("rawtypes")
	public static int function(int n, int[] arr) {
		
		//Array List 'chain' will keep track of the collatz sequence for starting number 'n'
		@SuppressWarnings("unchecked")
		ArrayList<Long> chain = new ArrayList();
		
		//For space purposes, we will be using a 'long' data type
		long num = n;
		
		chain.add(num);
		
		//If we encounter a value 'num' that we already passed with a previous 'n',
		//we can just add the current chain length with arr[num].
		//The value of arr[num] will be saved in 'fillIn'.
		int fillIn = 0;
		
		while(num != 1) {
			
			//if arr[(int) num] != 0, meaning we already encountered 'num' in a previous 'n'
			//fillIn saves the value of arr[num]
			if(num < arr.length && num >= 0 && arr[(int) num] != 0) {
				fillIn = arr[(int) num];
				break;
			}
			
			if(num % 2 == 0) num /= 2;
			else num = (3*num) + 1;
			
			chain.add(num);
		}
		
		for(int i = 0; i < chain.size(); i++) {
			long temp = chain.get(i);
			//Update arr[] by starting with arr[chain.get(0)] and ending with arr[chain.get(chain.size()-1)]
			//Enter in chain.size() + fillIn - 1 to 0 respectively.
			if(chain.get(i) < arr.length && chain.get(i) >= 0) arr[(int) temp] = chain.size() + fillIn - i - 1;
		}
		
		long val = chain.get(0);
		return arr[(int) val];
		
	}


}
