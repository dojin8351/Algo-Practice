package swea.d1;

import java.util.Scanner;

public class No2070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		
		for(int i = 0; i < testCaseCnt; i++) {
			String result = "";
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a > b) {
				result = ">";
			}else if(a == b) {
				result = "=";
			}else {
				result = "<";
			}
			System.out.printf("#%d %s\n",i + 1, result);
		}
		
	}

}
