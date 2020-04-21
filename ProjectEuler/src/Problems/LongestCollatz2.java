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

public class LongestCollatz2 {
	
	private static final int RANGE = 1000000;

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		int max = Integer.MIN_VALUE;
		int num = 1; 
		for(int i = 1; i <= RANGE; i++) {
			int val = funct(i);
			if(val > max) {
				max = val;
				num = i;
			}
		}
		
		long endTime = System.nanoTime();
		
		//OUTPUT: Number: 837799 Times: 524 Duration: 0.415340068 sec
		System.out.println("Number: " + num + " Times: " + max + " Duration: " + (endTime - startTime)/Math.pow(10, 9) + " sec");
	}
	
	public static int funct(int num) {
		int times = 0;
		long number = num;
		while(number != 1) {
			if(number % 2 == 0) {
				number /= 2;
			} else {
				number = (3*number) + 1;
			}
			times++;
		}
		return times;
	}
	

}
