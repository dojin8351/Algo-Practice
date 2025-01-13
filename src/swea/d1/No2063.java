package swea.d1;

import java.util.Arrays;
import java.util.Scanner;

public class No2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		int centerIndex = testCaseCnt /2;
		
		int[] arr = new int[testCaseCnt];
		for(int i = 0; i < testCaseCnt; i++) {
			int n = sc.nextInt();
			arr[i] = n;
		}
		Arrays.sort(arr);
		System.out.println(arr[centerIndex]);
	}
}
