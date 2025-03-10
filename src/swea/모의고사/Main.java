package swea.모의고사;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); //입력

        int N = str.length(); // 입력값 길이 구하기 

        char[][] ans; //문자 넣을 배열

        int r;
        int c;

        if(N%2 == 1) {//홀수일 경우
            r = N;//행의 갯수가 N개
            c = 1;
            ans = new char[r][c];

            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    ans[i][j] = str.charAt(i);
                }
            }

        } else {
//            System.out.println(Math.sqrt(N));
            int max = 0;
            for(int i=1; i<=Math.sqrt(N); i++) {// Math.sqrt 제곱근해서 거기까지 계산하기
                int value = N%i;

                if(value == 0) {//N이 i로 떨어지는 값일 경우
                    int p = i; //i값을 p에 저장

                    if(max<p) {
                        max = p; //max값 갱신
                    }
                }
            }

            r = max;//r값이 c보다 더 크니까
            c = N/max;//r*c=N이니까

            ans = new char[r][c]; // 배열 크기 설정해서 선언

            int k=0;
            for(int j=0; j<c; j++) {
                for(int i=0; i<r; i++) {
                    ans[i][j] = str.charAt(k);
                    k++;
                }
            }

        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(ans[i][j]);
            }
        }

    }
}