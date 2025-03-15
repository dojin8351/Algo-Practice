package baekjoon.dohyeon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    /*
        5로 나누었을때 바로 떨어지면 그값을 count에 넣고 출력, 나누어 떨어지지 않으면 3을빼주고 다시 5로 나누어본뒤 떨어지면 출력, 안떨어지면 -3 N < 0 때까지 반복
        만약 N<0이 된다면 -1출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }
            
            N -= 3;
            count++;

            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
