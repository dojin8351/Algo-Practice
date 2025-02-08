package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class No1220_Magnetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1;
        while(n <= 10) {
            int size = sc.nextInt();
            int[][] inputArr = new int[size][size];
            // sb : 배열의 열의 요소들을 담아준다.
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    inputArr[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for(int j = 0; j < size; j++) {
                for(int i = 0; i < size; i++) {
                    // 0은 다 날리고 1,2만 담기도록 설정
                    if(inputArr[i][j] != 0){
                        sb.append(inputArr[i][j]);
                    }
                }

                for(int i = 1; i < sb.length(); i++) {
                    // 12가 존재한다면 교착상태 이므로 12인 경우를 카운팅
                    if(sb.charAt(i-1) == '1' && sb.charAt(i) == '2') {
                        cnt++;
                    }
                }
                sb.setLength(0);
            }

            System.out.printf("#%d %d\n",n,cnt);
            n++;
        }

    }
}
