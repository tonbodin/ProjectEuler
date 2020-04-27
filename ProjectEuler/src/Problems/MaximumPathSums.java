/*

Problem #18: 

Given the following tree, find the maximum path: 

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

Problem #67: 

In the file: C:\Users\tonbo\Documents\sumtree2.txt

Using dynamic programming. 

 */



package Problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaximumPathSums {
	
	public static final int ROWS = 100;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int[] vals = new int[ROWS*(ROWS + 1)/2];
		
		File f = new File("C:\\Users\\tonbo\\Documents\\sumtree2.txt");
		Scanner sc = new Scanner(f);
		
		for(int i = 0; i < vals.length; i++) {
			vals[i] = sc.nextInt();
		}
		
		//referral to the level of each starting index, 
		//given by the values in the array
		int[] level = new int[ROWS];
		
		for(int i = 0; i < ROWS; i++) {
			if(i == 0) {
				level[i] = 0;
			} else {
				level[i] = level[i-1] + i;
			}
		}
		
		for(int i = ROWS - 1; i >= 1; i--) {
			for(int j = level[i]; j < level[i] + i; j++) {
				vals[j-i] = Math.max(vals[j], vals[j+1]) + vals[j-i];
			}
		}
		
		System.out.println("Maximum Value: " + vals[0]);
		
		
	}

}
