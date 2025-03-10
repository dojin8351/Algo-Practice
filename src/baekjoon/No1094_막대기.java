package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1094_막대기 {

    /*
        - 64는 2의 6제곱 절반을 나눈다 생각하면 비트를 왼쪽으로 한칸 옮겨주면 된다.
        - value가 0보다 클때까지만 비트를 왼쪽으로 1씩밀어주며 연산해준다 그리고 만약 밀린 value의 2진법 자리가 1이라면 count++
        - 계속 비트를 왼쪽으로 밀고 대입

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());
        int count = 0;

        while (value > 0) {
            count += value & 1;
            value >>= 1;
        }

        System.out.println(count);
    }
}