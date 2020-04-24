/*

Problem #23: Non-Abundant Sums

A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and 
it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
the smallest number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 
can be written as the sum of two abundant numbers. 
However, this upper limit cannot be reduced any further by analysis 
even though it is known that the greatest number that cannot be expressed 
as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

package Problems;

import java.util.ArrayList;

public class AbundantSums1 {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer> ();
		
		int[] tracker = new int[28123];
		
		for(int i = 0; i < 28123; i++) {
			if(sumFactors(i) > i) {
				arr.add(i);
			}
		}
		
		for(int i = 0; i < arr.size(); i++) {
			for(int j = i; j < arr.size(); j++) {
				if(arr.get(i) + arr.get(j) < 28123) {
					tracker[arr.get(i) + arr.get(j)] = 1;
				}
			}
		}
		
		int sum = 0; 
		
		for(int i = 0; i < tracker.length; i++) {
			if(tracker[i] != 1) sum += i;
		}
		
		System.out.println(sum);
		
	}
	
	public static int sumFactors(int n) {
		
		int sum = 0;
		
		for(int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		
		return sum;
		
	}

}
