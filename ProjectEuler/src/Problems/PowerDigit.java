
/*
 * Calculate the sum of the digits of 2^1000
 */

package Problems;

import java.math.BigInteger;

public class PowerDigit {

	public static void main(String[] args) {
		
		BigInteger num = new BigInteger("2");
		num = num.pow(1000);
		
		String[] n = num.toString().split("");
		int sum = 0;
		for(int i = 0; i < n.length; i++) {
			sum += Integer.parseInt(n[i]);
		}
	
		System.out.println(sum);

	}

}
