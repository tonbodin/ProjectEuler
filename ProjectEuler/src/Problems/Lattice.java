package Problems;

import java.math.BigInteger;

public class Lattice {
	
	private static final int dim = 3;
	
	public static void main(String[] args) {
		
		int[][] grid = new int[dim+1][dim+1];
		
		for(int i = 0; i < dim + 1; i++) {
			grid[i][dim] = 1; 
			grid[dim][i] = 1;
		}
		
		for(int i = dim + 1; i >= 0; i--) {
			for(int j = dim + 1; j >= 0; j--) {
				grid[i][j] = grid[i+1][j] + grid[i][j+1];
			}
		}
		
		System.out.println("Paths: " + grid[0][0]);
		
	}

	
	
}
