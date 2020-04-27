package Problems;

/*
 * Problem #9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class SpecialPythagorean {
	
	public static void main(String[] args) {

		for(int i = 1; i < 1000; i++) {
			System.out.println(i);
			for(int j = i; j < 1000; j++) {
				double c = findC(i, j);
				if(c % 1 == 0) {
					if(i + j + c == 1000) {
						System.out.println(i + " * " + j + " * " + c + " = " + (long) (i*j*c));
						return;
					}
				}
			}
		}
		
	}
	
	public static double findC(int a, int b) {
		return Math.sqrt((a*a) + (b*b));
	}

}
