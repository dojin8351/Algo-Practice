package swea.d1;

import java.util.Scanner;

public class No2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		
		for(int i = 0; i < testCaseCnt; i++) {
			int maxNum = 0;
			for(int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				if(n > maxNum) {
					maxNum = n;
				}
			}
			System.out.printf("#%d %d\n", i+1, maxNum);
		}
	
	}
}
